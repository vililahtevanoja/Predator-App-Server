package models

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class PlayTypeSpec extends PlaySpec {
  "PlayType" must {
    "be able to converted to from valid JSON containing all of its data" in {
      val expectedPlayType = PlayType(Some(1), "Run")
      val PlayTypeJsonString =
        """{
          |  "id": 1,
          |  "name": "Run"
          |   }""".stripMargin
      val actualPlayType = Json.parse(PlayTypeJsonString).as[PlayType]
      actualPlayType mustBe expectedPlayType
    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in {
      val expectedPlayType = PlayType(None, "Run")
      val PlayTypeJsonString =
        """{
          |  "name": "Run"
          |}""".stripMargin
      val actualPlayType = Json.parse(PlayTypeJsonString).as[PlayType]
      actualPlayType mustBe expectedPlayType
    }
  }
}
