package models

import java.sql.Date

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class GameSpec extends PlaySpec {
  "Game" must {
    "be able to converted to from valid JSON containing all of its data" in {
      val expectedGame = Game(Some(1), 1, 2, new Date(1514757600000L))
      val gameJsonString =
        """{
          |  "id": 1,
          |  "homeTeamId": 1,
          |  "visitorTeamId": 2,
          |  "date": "2018-01-01T00:00:00.00Z"
          |   }""".stripMargin
      val actualGame = Json.parse(gameJsonString).as[Game]
      actualGame mustBe expectedGame
    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in {
      val expectedGame = Game(None, 1, 2, new Date(1514757600000L))
      val gameJsonString =
        """{
          |  "homeTeamId": 1,
          |  "visitorTeamId": 2,
          |  "date": "2018-01-01T00:00:00.000Z"
          |}""".stripMargin
      val actualGame = Json.parse(gameJsonString).as[Game]
      actualGame mustBe expectedGame
    }
  }
}
