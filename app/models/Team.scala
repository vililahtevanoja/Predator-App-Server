package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Team(id: Option[Int], name: String)

object Team {
  implicit val teamReads: Reads[Team] = (
    (JsPath \ "id").readNullable[Int] and
      (JsPath \ "name").read[String]
    )(Team.apply _)
  implicit val teamWrites: Writes[Team] = (
    (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "name").write[String]
    )(unlift(Team.unapply))
}
