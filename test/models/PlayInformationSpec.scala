package models

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.libs.json.Json

@RunWith(classOf[JUnitRunner])
class PlayInformationSpec extends PlaySpec {
  "PlayInformation" must {
    "be able to converted to from valid JSON containing all of its data" in {
      val expectedPlayInformation = PlayInformation(Some(1), "Lead", 1)
      val PlayInformationJsonString =
        """{
          |  "id": 1,
          |  "name": "Lead",
          |  "playTypeId": 1
          |   }""".stripMargin
      val actualPlayInformation = Json.parse(PlayInformationJsonString).as[PlayInformation]
      actualPlayInformation mustBe expectedPlayInformation
    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in {
      val expectedPlayInformation = PlayInformation(None, "Lead", 1)
      val PlayInformationJsonString =
        """{
          |  "name": "Lead",
          |  "playTypeId": 1
          |}""".stripMargin
      val actualPlayInformation = Json.parse(PlayInformationJsonString).as[PlayInformation]
      actualPlayInformation mustBe expectedPlayInformation
    }
  }
}
