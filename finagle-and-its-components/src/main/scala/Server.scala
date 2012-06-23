package jp.w3ch.experiment.finagle

import java.net.InetSocketAddress

import com.twitter.finagle.http.Http
import com.twitter.finagle.builder.{Server => FServer, ServerBuilder}
import com.twitter.conversions.time._

import jp.w3ch.experiment.finagle.server.SleepAndEcho


object ServerMain extends App {

  try {
    Server.run()
    System.in.read()

  } finally {
    Server.close()
  }

}


object Server {

  var server:Option[FServer] = None

  def run() {
    val sb = ServerBuilder()
      .name   ("sample server")
      .codec  (Http())
      .bindTo (new InetSocketAddress(3000))

      .maxConcurrentRequests     (1000)
      .hostConnectionMaxLifeTime (5.minutes)
      .readTimeout               (2.minutes)

    server = Option(sb.build(SleepAndEcho))
  }

  def close() { for (s <- server) s.close() }
}


// vim: set shiftwidth=2 expandtab :
