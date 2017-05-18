package dao

import models.Team
import slick.driver.H2Driver.api._
import slick.lifted.Tag

class Teams(tag: Tag) extends Table[Team](tag, "teams") {
  val id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  val name: Rep[String] = column[String]("name")
  def * = (id.?, name) <> ((Team.apply _).tupled, Team.unapply)
}

object Teams {
  val objects: TableQuery[Teams] = TableQuery[Teams]
}
