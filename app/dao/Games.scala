package dao

import models.{Game, Team}
import slick.driver.H2Driver.api._
import slick.lifted.{ForeignKeyQuery, Tag}
import java.sql.Date

class Games(tag: Tag) extends Table[Game](tag, "games") {
  def id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def homeTeamId: Rep[Int] = column[Int]("home_team_id")
  def visitorTeamId: Rep[Int] = column[Int]("visitor_team_id")
  def date: Rep[Date] = column[Date]("date")
  def * = (id.?, homeTeamId, visitorTeamId, date) <> ((Game.apply _).tupled, Game.unapply)
  def homeTeamFk: ForeignKeyQuery[Teams, Team] = foreignKey("home_team", homeTeamId, Teams.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)
  def visitorTeamFk: ForeignKeyQuery[Teams, Team] = foreignKey("visitor_team", visitorTeamId, Teams.objects)(_.id, onUpdate=ForeignKeyAction.Restrict, onDelete=ForeignKeyAction.Cascade)

}

object Games {
  val objects: TableQuery[Games] = TableQuery[Games]
}