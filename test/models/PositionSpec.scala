package models

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class PositionSpec extends PlaySpec {
  "Position" must {
    "be able to converted to from valid JSON containing all of its data" in {
      val expectedPosition = Position(Some(1), "Flexbone")
      val PositionJsonString =
        """{
          |  "id": 1,
          |  "name": "Flexbone"
          |   }""".stripMargin
      val actualPosition = Json.parse(PositionJsonString).as[Position]
      actualPosition mustBe expectedPosition
    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in {
      val expectedPosition = Position(None, "Flexbone")
      val PositionJsonString =
        """{
          |  "name": "Flexbone"
          |}""".stripMargin
      val actualPosition = Json.parse(PositionJsonString).as[Position]
      actualPosition mustBe expectedPosition
    }
  }
}
