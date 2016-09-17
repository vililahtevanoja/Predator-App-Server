package dao

import java.sql.Date

import models.Game
import slick.driver.H2Driver.api._
import slick.lifted.Tag

class Games(tag: Tag) extends Table[Game](tag, "games") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def homeTeam = column[Int]("home_team_id")
  def visitorTeam = column[Int]("visitor_team_id")
  def date = column[Date]("date")
  def * = (id.?, homeTeam, visitorTeam, date) <> ((Game.apply _).tupled, Game.unapply)
}

object Games {
  val objects = TableQuery[Games]
}