package filters

import javax.inject.Inject

import akka.stream.Materializer
import play.api.Logger
import play.api.mvc._

import scala.concurrent.{ExecutionContext, Future, Await}
import scala.concurrent.duration._

class LoggingFilter @Inject() (implicit val mat: Materializer, val ec: ExecutionContext) extends Filter {
  def apply(nextFilter: RequestHeader => Future[Result])
           (requestHeader: RequestHeader): Future[Result] = {

    val startTime = System.currentTimeMillis

    nextFilter(requestHeader).map { result =>

      val endTime = System.currentTimeMillis
      val requestTime = endTime - startTime

      val loggingFuture = result.body.consumeData.map(_.utf8String).map { str =>

        val dataStr =  str.stripPrefix("\n\n").startsWith("<") match {
          case true => str.replace("\n", "")
          case false => str
        }

        Logger.info(s"${requestHeader.method} ${requestHeader.uri} - ${requestTime}ms - RETURN: ${result.header.status} - DATA: ${dataStr}")
      }
      Await.result(loggingFuture, 5000 millis)

      result.withHeaders("Request-Time" -> requestTime.toString)
    }
  }
}