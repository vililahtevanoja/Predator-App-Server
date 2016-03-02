package models

import play.api.libs.json._
import play.api.libs.functional.syntax._

case class DownInformation(val id: Option[Int],
                           val name: String,
                           val down: Int,
                           val yards: Int,
                           val gained: Int,
                           val formationId: Int,
                           val playId: Int,
                           val targetId: Int)

object DownInformation {
  implicit val downInformationReads: Reads[DownInformation] = (
      (JsPath \ "id").readNullable[Int] and
      (JsPath \ "name").read[String] and
      (JsPath \ "down").read[Int] and
      (JsPath \ "yards").read[Int] and
      (JsPath \ "gained").read[Int] and
      (JsPath \ "formationId").read[Int] and
      (JsPath \ "playId").read[Int] and
      (JsPath \ "targetId").read[Int]
    )(DownInformation.apply _)

  implicit val downInformationWrites: Writes[DownInformation] = (
    (JsPath \ "id").writeNullable[Int] and
      (JsPath \ "name").write[String] and
      (JsPath \ "down").write[Int] and
      (JsPath \ "yards").write[Int] and
      (JsPath \ "gained").write[Int] and
      (JsPath \ "formationId").write[Int] and
      (JsPath \ "playId").write[Int] and
      (JsPath \ "targetId").write[Int]
    )(unlift(DownInformation.unapply))
}