package models

import java.sql.Date

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class Game(id: Option[Int], homeTeamId: Int, visitorTeamId: Int, date: Date)

object Game {
  implicit val gameReads: Reads[Game] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "homeTeamId").read[Int] and
      (JsPath \ "visitorTeamId").read[Int] and
      (JsPath \ "date").read[Date]
  )(Game.apply _)

  implicit val gameWrites: Writes[Game] = (
      (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "homeTeamId").write[Int] and
      (JsPath \ "visitorTeamId").write[Int] and
      (JsPath \"date").write[Date]
    )(unlift(Game.unapply))
}
