package dao

import models.Position
import slick.driver.H2Driver.api._
import slick.lifted.Tag

class Positions(tag: Tag) extends Table[Position](tag, "positions")  {
  val id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  val name = column[String]("name")
  def * = (id.?, name) <> ((Position.apply _).tupled, Position.unapply)
}

object Positions {
  val objects = TableQuery[Positions]
}