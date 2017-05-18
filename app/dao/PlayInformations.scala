package dao

import models.{PlayInformation, PlayType}
import slick.lifted.{ForeignKeyQuery, Tag}
import slick.driver.H2Driver.api._

class PlayInformations(tag: Tag) extends Table[PlayInformation](tag, "play_informations") {
  val id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  val name: Rep[String] = column[String]("name")
  val playTypeId: Rep[Int] = column[Int]("playtype_id")
  def * = (id.?, name, playTypeId) <> ((PlayInformation.apply _).tupled, PlayInformation.unapply)
  val playType: ForeignKeyQuery[PlayTypes, PlayType] = foreignKey("playType", playTypeId, PlayTypes.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
}

object PlayInformations {
  val objects: TableQuery[PlayInformations] = TableQuery[PlayInformations]
}