package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Formation(id: Option[Int], name: String)

object Formation {
  implicit val formationReads: Reads[Formation] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "name").read[String]
    )(Formation.apply _)

  implicit val formationWrites: Writes[Formation]= (
      (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "name").write[String]
    )(unlift(Formation.unapply))
}