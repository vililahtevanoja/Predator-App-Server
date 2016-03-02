package dao

import models.{PlayType, PlayInformation}
import slick.lifted.Tag
import slick.driver.H2Driver.api._

class PlayInformations(tag: Tag) extends Table[PlayInformation](tag, "play_informations") {
  val id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  val name = column[String]("name")
  val playTypeId = column[Int]("playtype_id")
//  val playType = column[PlayType]("playtype")
  def * = (id.?, name, playTypeId) <> ((PlayInformation.apply _).tupled, PlayInformation.unapply)
  val playType = foreignKey("playType", playTypeId, PlayTypes.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
}

object PlayInformations {
  val objects = TableQuery[PlayInformations]
}