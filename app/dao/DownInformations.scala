package dao

import models._
import slick.lifted.{ForeignKeyQuery, Tag}
import slick.driver.H2Driver.api._

class DownInformations(tag: Tag) extends Table[DownInformation](tag, "down_informations") {
  def id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name: Rep[String] = column[String]("name")
  def down: Rep[Int] = column[Int]("down")
  def yards: Rep[Int] = column[Int]("yards")
  def gained: Rep[Int] = column[Int]("gained")
  def playId: Rep[Int] = column[Int]("play_id")
  def targetId: Rep[Int] = column[Int]("target_id")
  def formationId: Rep[Int] = column[Int]("formation_id")
  def gameId: Rep[Int] = column[Int]("game_id")
  def * = (id.?, name, down, yards, gained, formationId, playId, targetId, gameId) <> ((DownInformation.apply _).tupled, DownInformation.unapply)
  def formationFk: ForeignKeyQuery[Formations, Formation] = foreignKey("formation", formationId, Formations.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  def playFk: ForeignKeyQuery[PlayInformations, PlayInformation] = foreignKey("play", playId, PlayInformations.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  def targetFk: ForeignKeyQuery[Players, Player] = foreignKey("target", targetId, Players.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  def gameFk: ForeignKeyQuery[Games, Game] = foreignKey("game", gameId, Games.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
}
//   def supplier = foreignKey("SUP_FK", supID, suppliers)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
object DownInformations {
  val objects: TableQuery[DownInformations] = TableQuery[DownInformations]
}