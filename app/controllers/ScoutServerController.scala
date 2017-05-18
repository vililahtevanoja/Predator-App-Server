package controllers

import javax.inject.Inject

import dao._
import models._
import play.api.Logger
import play.api.db.slick._
import play.api.libs.json.{JsValue, Json}
import play.api.mvc._
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ScoutServerController @Inject()(dbConfigProvider: DatabaseConfigProvider) extends Controller {
  val logger = Logger(this.getClass)
  val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  import dbConfig.driver.api._

  def index = Action {
    Ok("Hello, world. You're at the api index.")
  }

  def getFormations: Action[AnyContent] = Action.async {
    val formationsFuture: Future[Seq[Formation]] = dbConfig.db.run(Formations.objects.result)
    formationsFuture.map(formations => Ok(Json.toJson(formations)).withHeaders("Access-Control-Allow-Origin" -> "*"))
  }

  def getFormation(id: Int): Action[AnyContent] = Action.async {
    val formationFuture: Future[Option[Formation]] =
      dbConfig.db.run(Formations.objects.filter(_.id === id).result.headOption)
    formationFuture.map {
      case Some(formation) => Ok(Json.toJson(formation)).withHeaders("Access-Control-Allow-Origin" -> "*")
      case None => NotFound
    }
  }

  def addFormation: Action[JsValue] = Action.async(parse.json) { request =>
    val formation = request.body.as[Formation]
    Future {
      dbConfig.db.run(Formations.objects += formation)
      Ok(Json.toJson(formation)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }

  def getPlays: Action[AnyContent] = Action.async {
    val playsFuture: Future[Seq[PlayInformation]] = dbConfig.db.run(PlayInformations.objects.result)
    playsFuture.map(plays => Ok(Json.toJson(plays)).withHeaders("Access-Control-Allow-Origin" -> "*"))
  }

  def getPlay(id: Int): Action[AnyContent] = Action.async {
    val playFuture: Future[Option[PlayInformation]] =
      dbConfig.db.run(PlayInformations.objects.filter(_.id === id).result.headOption)
    playFuture.map {
      case Some(play) => Ok(Json.toJson(play)).withHeaders("Access-Control-Allow-Origin" -> "*")
      case None => NotFound
    }
  }

  def addPlay: Action[JsValue] = Action.async(parse.json) { request =>
    val play = request.body.as[PlayInformation]
    Future {
      dbConfig.db.run(PlayInformations.objects += play)
      Ok(Json.toJson(play)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }

  def getDowns: Action[AnyContent] = Action.async {
    val downsFuture: Future[Seq[DownInformation]] = dbConfig.db.run(DownInformations.objects.result)
    downsFuture.map(downs => Ok(Json.toJson(downs)).withHeaders("Access-Control-Allow-Origin" -> "*"))
  }

  def getDown(id: Int) = Action.async {
    val downFuture: Future[Option[DownInformation]] =
      dbConfig.db.run(DownInformations.objects.filter(_.id === id).result.headOption)
    downFuture.map {
      case Some(down) => Ok(Json.toJson(down)).withHeaders("Access-Control-Allow-Origin" -> "*")
      case None => NotFound
    }
  }

  def addDown: Action[JsValue] = Action.async(parse.json) {request =>
    val down = request.body.as[DownInformation]
    Future {
      dbConfig.db.run(DownInformations.objects += down)
      Ok(Json.toJson(down)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }


  def getPlayTypes: Action[AnyContent] = Action.async {
    val playTypesFuture: Future[Seq[PlayType]] = dbConfig.db.run(PlayTypes.objects.result)
    playTypesFuture.map {
      case playTypes => Ok(Json.toJson(playTypes)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }

  def getPlayType(id: Int): Action[AnyContent] = Action.async {
    val playTypeFuture: Future[Option[PlayType]] =
      dbConfig.db.run(PlayTypes.objects.filter(_.id === id).result.headOption)
    playTypeFuture.map {
      case Some(playType) => Ok(Json.toJson(playType)).withHeaders("Access-Control-Allow-Origin" -> "*")
      case None => NotFound
    }
  }

  def addPlayType: Action[JsValue] = Action.async(parse.json) { request =>
    val playType = request.body.as[PlayType]
    Future {
      dbConfig.db.run(PlayTypes.objects += playType)
      Ok(Json.toJson(playType)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }

  def getPositions: Action[AnyContent] = Action.async {
    val positionsFuture: Future[Seq[Position]] = dbConfig.db.run(Positions.objects.result)
    positionsFuture.map {
      case positions => Ok(Json.toJson(positions))
    }
  }

  def getPosition(id: Int): Action[AnyContent] = Action.async {
    val positionFuture: Future[Option[Position]] =
      dbConfig.db.run(Positions.objects.filterNot(_.id === id).result.headOption)
    positionFuture.map {
      case Some(position) => Ok(Json.toJson(position)).withHeaders("Access-Control-Allow-Origin" -> "*")
      case None => NotFound
    }
  }

  def getPlayers: Action[AnyContent] = Action.async {
    val playersFuture = dbConfig.db.run(Players.objects.result)
    playersFuture.map {
      case players => Ok(Json.toJson(players)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }

  def getPlayer(id: Int): Action[AnyContent] = Action.async {
    val playerFuture: Future[Option[Player]] =
      dbConfig.db.run(Players.objects.filter(_.id === id).result.headOption)
    playerFuture.map {
      case Some(player) => Ok(Json.toJson(player)).withHeaders("Access-Control-Allow-Origin" -> "*")
      case None => NotFound
    }
  }

  def addPlayer(id: Int): Action[JsValue] = Action.async(parse.json) { request =>
    val player = request.body.as[Player]
    Future {
      dbConfig.db.run(Players.objects += player)
      Ok(Json.toJson(player)).withHeaders("Access-Control-Allow-Origin" -> "*")
    }
  }

  def getGame(id: Int): Action[JsValue] = Action.async(parse.json) { request =>
    val gameFuture: Future[Option[Game]] =
      dbConfig.db.run(Games.objects.filter(_.id === id).result.headOption)
    gameFuture.map {
      case Some(game) => Ok(Json.toJson(game)).withHeaders("Access-Control-Allow-Origin" -> "*")
      case None => NotFound
    }
  }
}
