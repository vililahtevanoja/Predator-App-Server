package models

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class TeamSpec extends PlaySpec {
  "Team" must {
    "be able to converted to from valid JSON containing all of its data" in {
      val expectedTeam = Team(Some(1), "Aalto Predators")
      val TeamJsonString =
        """{
          |  "id": 1,
          |  "name": "Aalto Predators"
          |   }""".stripMargin
      val actualTeam = Json.parse(TeamJsonString).as[Team]
      actualTeam mustBe expectedTeam
    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in {
      val expectedTeam = Team(None, "Aalto Predators")
      val TeamJsonString =
        """{
          |  "name": "Aalto Predators"
          |}""".stripMargin
      val actualTeam = Json.parse(TeamJsonString).as[Team]
      actualTeam mustBe expectedTeam
    }
  }
}
