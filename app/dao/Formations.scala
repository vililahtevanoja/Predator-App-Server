package dao

import models.Formation
import slick.driver.H2Driver.api._
import slick.lifted.Tag

class Formations(tag: Tag) extends Table[Formation](tag, "formations") {
  def id = column[Int]("id", O.PrimaryKey, O.AutoInc)
  def name = column[String]("name")
  def * = (id.?, name) <> ((Formation.apply _).tupled, Formation.unapply)
}

object Formations {
  val objects = TableQuery[Formations]
}