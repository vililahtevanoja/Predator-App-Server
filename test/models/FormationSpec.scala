package models

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatestplus.play._
import play.api.libs.json.Json
import play.api.test._
import play.api.test.Helpers._

@RunWith(classOf[JUnitRunner])
class FormationSpec extends PlaySpec {
  "Formation" must {
    "be able to converted to from valid JSON containing all of its data" in {
      val expectedFormation = Formation(Some(1), "Flexbone")
      val FormationJsonString =
        """{
          |  "id": 1,
          |  "name": "Flexbone"
          |   }""".stripMargin
      val actualFormation = Json.parse(FormationJsonString).as[Formation]
      actualFormation mustBe expectedFormation
    }
  }
  it should {
    "be able to be converted to from valid JSON containing all of its data except for the id" in {
      val expectedFormation = Formation(None, "Flexbone")
      val FormationJsonString =
        """{
          |  "name": "Flexbone"
          |}""".stripMargin
      val actualFormation = Json.parse(FormationJsonString).as[Formation]
      actualFormation mustBe expectedFormation
    }
  }
}
