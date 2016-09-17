package models

import java.sql.Date

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Game(id: Option[Int], homeTeam: String, visitorTeam: String, date: Date)

object Game {
  implicit val gameReads: Reads[Game] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "homeTeam").read[String] and
      (JsPath \ "visitorTeam").read[String] and
      (JsPath \ "date").read[Date]
  )(Game.apply _)

  implicit val gameWrites: Writes[Game] = (
      (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "homeTeam").write[String] and
      (JsPath \ "visitorTeam").write[String] and
      (JsPath \"date").write[Date]
    )(unlift(Game.unapply))
}
