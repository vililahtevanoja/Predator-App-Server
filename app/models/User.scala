package models

import com.mohiva.play.silhouette.api.{Identity, LoginInfo}

/**
  * Created on 2016-09-29.
  *
  * @author vili
  */
case class User(
                 userID: Option[Int],
//                 loginInfo: LoginInfo,
                 username: String,
                 email: String,
                 password: String) //extends Identity
