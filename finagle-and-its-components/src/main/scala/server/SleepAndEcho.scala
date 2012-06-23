package jp.w3ch.experiment.finagle.server

import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

import com.twitter.conversions.time._
import com.twitter.util.JavaTimer
import com.twitter.finagle.Service
import com.twitter.finagle.http.Response
import org.jboss.netty.handler.codec.http._


object SleepAndEcho extends Service[HttpRequest, HttpResponse] {

  override def apply(request:HttpRequest) = {
    val message = request.getUri.replaceFirst(".*/", "")
    val sleep = try { message.toInt } catch { case _ => 0 }

    new JavaTimer(true).doLater(sleep.second) {
      val text = if (sleep == 0) { message } else { (sleep * 2).toString }
      makeResponse(text)
    }
  }

  def makeResponse(text: String):HttpResponse = {

    import org.jboss.netty.buffer.ChannelBuffers
    import org.jboss.netty.util.CharsetUtil.UTF_8

    val dateFormat = new SimpleDateFormat("EEE', 'dd' 'MMM' 'yyyy' 'HH:mm:ss' 'Z", Locale.US)
    def now = dateFormat.format(new Date())

    val bytes = text.getBytes(UTF_8)
    val body = ChannelBuffers.copiedBuffer(bytes)
    val headers = Seq(
      "Date"           -> now,
      "Content-Length" -> bytes.length.toString,
      "Connection"     -> "close",
      "Content-Type"   -> "text/plain",
      "res"            -> text
    )

    val response = Response()
    response.setContent(body)
    headers.foreach { kv => response.addHeader(kv._1, kv._2) }

    response
  }
}

// vim: set ts=2 sw=2 et:
