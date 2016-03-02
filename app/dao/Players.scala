package dao

import models.Player
import slick.driver.H2Driver.api._
import slick.lifted.Tag

class Players(tag: Tag) extends Table[Player](tag, "players") {
  val id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  val number = column[Int]("number")
  def * = (id.?, number) <> ((Player.apply _).tupled, Player.unapply)
}

object Players {
  val objects = TableQuery[Players]
}