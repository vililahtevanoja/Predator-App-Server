package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class PlayInformation(val id: Option[Int],
                           val name: String,
                           val playTypeId: Int)

object PlayInformation {
  implicit val playInformationReads: Reads[PlayInformation] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "name").read[String] and
      (JsPath \ "playtypeId").read[Int]
    )(PlayInformation.apply _)

  implicit val playInformationWrites: Writes[PlayInformation] = (
      (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "name").write[String] and
      (JsPath \ "playtypeId").write[Int]
    )(unlift(PlayInformation.unapply))
}