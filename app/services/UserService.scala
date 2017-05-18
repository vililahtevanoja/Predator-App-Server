package services

import com.google.inject.Inject
import com.mohiva.play.silhouette.api.LoginInfo
import com.mohiva.play.silhouette.api.services.IdentityService
import dao.Users
import models.User
import play.api.db.slick.DatabaseConfigProvider

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait UserService/* extends IdentityService[User]*/ {
  def save(user: User): Future[User]
}

class UserServiceImpl @Inject() (userDAO: Users, dbConfigProvider: DatabaseConfigProvider) extends UserService {
//  def retrieve(loginInfo: LoginInfo): Future[Option[User]] = userDAO.find(loginInfo)
//  def save(user: User) = userDAO.save(user)
  def retrieve(loginInfo: LoginInfo): Future[Option[User]] = Future { None }
  def save(user: User) = Future { user }
}
