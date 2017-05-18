package dao

import models.{Player, Team}
import slick.driver.H2Driver.api._
import slick.lifted.{ForeignKeyQuery, Tag}

class Players(tag: Tag) extends Table[Player](tag, "players") {
  val id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  val number: Rep[Int] = column[Int]("number")
  val teamId: Rep[Int] = column[Int]("team_id")
  def * = (id.?, number, teamId) <> ((Player.apply _).tupled, Player.unapply)
  def teamFk: ForeignKeyQuery[Teams, Team] = foreignKey("team", teamId, Teams.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
}

object Players {
  val objects: TableQuery[Players] = TableQuery[Players]
}