package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Position(val id: Option[Int], val name: String)

object Position {
  implicit val playerReads: Reads[Position] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "name").read[String]
    )(Position.apply _)

  implicit val playerWrites: Writes[Position] = (
      (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "name").write[String]
    )(unlift(Position.unapply))
}