package models

import java.sql.Date

import org.joda.time.DateTime
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
      val expectedGame = Game(Some(1), 1, 2, new Date(DateTime.parse("2018-01-01").toDate.getTime))
      val gameJsonString =
        """{
          |  "id": 1,
          |  "homeTeamId": 1,
          |  "visitorTeamId": 2,
          |  "date": "2018-01-01T00:00:00.00Z"
          |   }""".stripMargin
      val actualGame = Json.parse(gameJsonString).as[Game]
      actualGame.date.compareTo(expectedGame.date) mustEqual 0

    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in {
      val expectedGame = Game(None, 1, 2, new Date(DateTime.parse("2018-01-01").toDate.getTime))
      val gameJsonString =
        """{
          |  "homeTeamId": 1,
          |  "visitorTeamId": 2,
          |  "date": "2018-01-01T00:00:00.000Z"
          |}""".stripMargin
      val actualGame = Json.parse(gameJsonString).as[Game]
      actualGame.date.compareTo(expectedGame.date) mustEqual 0
      actualGame.visitorTeamId mustEqual expectedGame.visitorTeamId
      actualGame.homeTeamId mustEqual expectedGame.homeTeamId
    }
  }
}
