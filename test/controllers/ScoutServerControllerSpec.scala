package controllers

import org.junit.runner.RunWith
import org.specs2.mutable._
import org.specs2.runner.JUnitRunner

import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class ScoutServerControllerSpec extends Specification {
  "ScoutServerController" should {
    "send 404 on bad request" in new WithApplication {
      route(FakeRequest(GET, "/asdfasdf")) must beSome.which(status(_) == NOT_FOUND)
    }
  }
}
