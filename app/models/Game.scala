package models

import java.sql.Date

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Game(id: Option[Int], homeTeam: Int, visitorTeam: Int, date: Date)

object Game {
  implicit val gameReads: Reads[Game] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "homeTeam").read[Int] and
      (JsPath \ "visitorTeam").read[Int] and
      (JsPath \ "date").read[Date]
  )(Game.apply _)

  implicit val gameWrites: Writes[Game] = (
      (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "homeTeam").write[Int] and
      (JsPath \ "visitorTeam").write[Int] and
      (JsPath \"date").write[Date]
    )(unlift(Game.unapply))
}
