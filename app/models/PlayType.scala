package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class PlayType(val id: Option[Int], val name: String)

object PlayType {
  implicit val playTypeReads: Reads[PlayType] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "name").read[String]
  )(PlayType.apply _)

  implicit val playTypeWrites: Writes[PlayType] = (
      (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "name").write[String]
    )(unlift(PlayType.unapply))
}