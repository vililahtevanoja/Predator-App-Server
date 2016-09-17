package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Player(id: Option[Int], number: Int)

object Player {
  implicit val playerReads: Reads[Player] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "number").read[Int]
    )(Player.apply _)

  implicit val playerWrites: Writes[Player] = (
      (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "number").write[Int]
    )(unlift(Player.unapply))
}