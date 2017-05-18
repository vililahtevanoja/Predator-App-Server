package dao

import com.mohiva.play.silhouette.api.LoginInfo
import slick.lifted.Tag
import slick.driver.H2Driver.api._
import models.User

class Users(tag: Tag) extends Table[User](tag, "users") {
  val id = column[Int]("id", O.PrimaryKey, O.AutoInc)
//  val loginInfo = column[LoginInfo]("login_info")
  val username = column[String]("username")
  val email = column[String]("email")
//  def * = (id.?, loginInfo, username, email) <> ((User.apply _).tupled, User.unapply)
  val password = column[String]("password")
  def * = (id.?, username, email, password) <> ((User.apply _).tupled, User.unapply)
}

object Users {
  val objects = TableQuery[Users]
}