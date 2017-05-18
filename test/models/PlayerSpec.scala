package models

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class PlayerSpec extends PlaySpec {
  "Player" must {
    "be able to converted to from valid JSON containing all of its data" in {
      val expectedPlayer = Player(Some(1), 1, 66)
      val PlayerJsonString =
        """{
          |  "id": 1,
          |  "number": 66,
          |  "teamId": 1
          |   }""".stripMargin
      val actualPlayer = Json.parse(PlayerJsonString).as[Player]
      actualPlayer mustBe expectedPlayer
    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in {
      val expectedPlayer = Player(None, 1, 66)
      val PlayerJsonString =
        """{
          |  "number": 66,
          |  "teamId": 1
          |}""".stripMargin
      val actualPlayer = Json.parse(PlayerJsonString).as[Player]
      actualPlayer mustBe expectedPlayer
    }
  }
}
