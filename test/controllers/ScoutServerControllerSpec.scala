package controllers

import org.junit.runner.RunWith
import org.scalamock.scalatest.MockFactory
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.inject.guice.GuiceApplicationBuilder
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class ScoutServerControllerSpec extends PlaySpec with OneAppPerSuite with MockFactory {
  implicit override lazy val app = new GuiceApplicationBuilder().build()
  "ScoutServerController" should {
    "send 404 on bad request" in {
      val resp = route(app, FakeRequest(GET, "/asdfasdf"))
      resp mustBe defined
      status(resp.get) mustEqual NOT_FOUND
    }
  }
}
