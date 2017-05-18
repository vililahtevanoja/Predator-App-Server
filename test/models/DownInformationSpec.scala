package models

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.libs.json._
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class DownInformationSpec extends PlaySpec {
  "DownInformation" must {
    "be able to converted to from valid JSON containing all of its data" in new WithApplication {
      val expectedDownInformation = DownInformation(Some(1), "Lead", 1, 3, 3, 2, 3, 2, 1)
      val downInformationJsonString =
        """{
          |  "id": 1,
          |  "name": "Lead",
          |  "down": 1,
          |  "yards": 3,
          |  "gained": 3,
          |  "formationId": 2,
          |  "playId": 3,
          |  "targetId": 2,
          |  "gameId": 1
          |   }""".stripMargin
      val actualDownInformation = Json.parse(downInformationJsonString).as[DownInformation]
      actualDownInformation mustBe expectedDownInformation
    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in new WithApplication {
      val expectedDownInformation = DownInformation(None, "Lead", 1, 3, 3, 2, 3, 2, 1)
      val downInformationJsonString =
        """{
          |  "name": "Lead",
          |  "down": 1,
          |  "yards": 3,
          |  "gained": 3,
          |  "formationId": 2,
          |  "playId": 3,
          |  "targetId": 2,
          |  "gameId": 1
          |  }""".stripMargin
      val actualDownInformation = Json.parse(downInformationJsonString).as[DownInformation]
      actualDownInformation mustBe expectedDownInformation
    }
  }
}
