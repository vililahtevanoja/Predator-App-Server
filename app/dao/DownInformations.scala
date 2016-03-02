package dao

import models.{Player, PlayInformation, Formation, DownInformation}
import slick.lifted.Tag
import slick.driver.H2Driver.api._

class DownInformations(tag: Tag) extends Table[DownInformation](tag, "down_informations") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def down = column[Int]("down")
  def yards = column[Int]("yards")
  def gained = column[Int]("gained")
  def formationId = column[Int]("formation_id")
  def playId = column[Int]("play_id")
  def targetId = column[Int]("target_id")
//  def target = column[Player]("target")
  def * = (id.?, name, down, yards, gained, formationId, playId, targetId) <> ((DownInformation.apply _).tupled, DownInformation.unapply)
  def formationFk = foreignKey("formation", formationId, Formations.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  def playFk = foreignKey("play", playId, PlayInformations.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  def targetFk = foreignKey("target", targetId, PlayInformations.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
}
//   def supplier = foreignKey("SUP_FK", supID, suppliers)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
object DownInformations {
  val objects = TableQuery[DownInformations]
}