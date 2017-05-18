package dao

import models.PlayType
import slick.driver.H2Driver.api._
import slick.lifted.Tag

class PlayTypes(tag: Tag) extends Table[PlayType](tag, "playtypes") {
  val id: Rep[Int] = column[Int]("id", O.PrimaryKey, O.AutoInc)
  val name: Rep[String] = column[String]("name")
  def * = (id.?, name) <> ((PlayType.apply _).tupled, PlayType.unapply)
}

object PlayTypes {
  val objects: TableQuery[PlayTypes] = TableQuery[PlayTypes]
}