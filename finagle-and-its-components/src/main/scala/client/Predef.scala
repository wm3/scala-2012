package jp.w3ch.experiment.finagle.client

import java.net.InetSocketAddress

import com.twitter.finagle.builder.ClientBuilder
import com.twitter.finagle.http.{Http,RequestBuilder}
import org.jboss.netty.handler.codec.http._


/**
 * 例:
 *
 * <pre>
 * import jp.w3ch.experiment.finagle.client.Predef._
 *
 * // 一度リクエストを送る Future
 * val f1 = fetch("localhost/3")
 * f1() // = 6
 *
 * // 一度リクエストを送ってから再度送る Future
 * val f2a = fetch("localhost/1") andThen { v1 =&gt; fetch("localhost/" + v1) }
 * f2a() // = 4
 *
 * // 一度リクエストを送ってから再度送る Future の for 版
 * val f2b = for {
 *   v1 &lt;- fetch("localhost/1")
 *   v2 &lt;- fetch("localhost/" + v1)
 * } yield (v1, v2)
 * f2b() // = (2,4)
 *
 * // 並列にリクエストを送る Future
 * val f3 = Future.collect ((1 to 10).map { i =&gt; fetch("localhost/" + i).onSuccess{println} })
 * f3() // = ArrayBuffer(2, 4, 6, 8, 10, 12, 14, 16, 18, 20)
 *
 * // このサンプルプログラムでは最後に release が必要
 * release()
 * </pre>
 */
object Predef {

  type Future[T] = com.twitter.util.Future[T]
  val Future = com.twitter.util.Future

  def newClient = ClientBuilder()
    .codec(Http())
    .hosts(new InetSocketAddress("localhost", 3000))
    .hostConnectionLimit(400)
    .build()

  val client = newClient
  def release() = client.release()

  def fetch(url:String) = {
    val c = client
    val request = RequestBuilder().url(new java.net.URL("http://" + url)).buildGet()

    c(request).map { _.getHeader("res") }
  }

}

// vim: set ts=2 sw=2 et:
