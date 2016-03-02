package controllers

import javax.inject.Inject

import dao._
import models._
import play.api.Logger
import play.api.db.slick._
import play.api.libs.json.Json
import play.api.mvc._
import slick.driver.JdbcProfile

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

class ScoutServerController @Inject()(dbConfigProvider: DatabaseConfigProvider)  extends Controller {
  val logger = Logger(this.getClass)
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  import dbConfig.driver.api._

  def index = Action {
    Ok("Hello, world. You're at the polls index.")
  }

  def getFormations = Action.async {
    val formationsFuture: Future[Seq[Formation]] = dbConfig.db.run(Formations.objects.result)
    formationsFuture.map {
      case formations => Ok(Json.toJson(formations))
    }
  }

  def getFormation(id: Int) = Action.async {
    val formationFuture: Future[Option[Formation]] =
      dbConfig.db.run(Formations.objects.filter(_.id === id).result.headOption)
    formationFuture.map {
      case Some(formation) => Ok(Json.toJson(formation))
      case None => NotFound
    }
  }

  def addFormation() = Action.async(parse.json) { request =>
    val formation = request.body.as[Formation]
    Future {
      dbConfig.db.run(Formations.objects += formation)
      Ok(Json.toJson(formation))
    }
  }

  def getPlays = Action.async {
    val playsFuture: Future[Seq[PlayInformation]] = dbConfig.db.run(PlayInformations.objects.result)
    playsFuture.map {
      case plays => Ok(Json.toJson(plays))
    }
  }

  def getPlay(id: Int) = Action.async {
    val playFuture: Future[Option[PlayInformation]] =
      dbConfig.db.run(PlayInformations.objects.filter(_.id === id).result.headOption)
    playFuture.map {
      case Some(play) => Ok(Json.toJson(play))
      case None => NotFound
    }
  }

  def addPlay() = Action.async(parse.json) { request =>
    val play = request.body.as[PlayInformation]
    Future {
      dbConfig.db.run(PlayInformations.objects += play)
      Ok(Json.toJson(play))
    }
  }

  def getDowns = Action.async {
    val downsFuture: Future[Seq[DownInformation]] = dbConfig.db.run(DownInformations.objects.result)
    downsFuture.map {
      case downs => Ok(Json.toJson(downs))
    }
  }

  def getDown(id: Int) = Action.async {
    val downFuture: Future[Option[DownInformation]] =
      dbConfig.db.run(DownInformations.objects.filter(_.id === id).result.headOption)
    downFuture.map {
      case Some(down) => Ok(Json.toJson(down))
      case None => NotFound
    }
  }

  def addDown() = Action.async(parse.json) {request =>
    val down = request.body.as[DownInformation]
    Future {
      dbConfig.db.run(DownInformations.objects += down)
      Ok(Json.toJson(down))
    }
  }


  def getPlayTypes = Action.async {
    val playTypesFuture: Future[Seq[PlayType]] = dbConfig.db.run(PlayTypes.objects.result)
    playTypesFuture.map {
      case playTypes => Ok(Json.toJson(playTypes))
    }
  }

  def getPlayType(id: Int) = Action.async {
    val playTypeFuture: Future[Option[PlayType]] =
      dbConfig.db.run(PlayTypes.objects.filter(_.id === id).result.headOption)
    playTypeFuture.map {
      case Some(playType) => Ok(Json.toJson(playType))
      case None => NotFound
    }
  }

  def addPlayType() = Action.async(parse.json) { request =>
    val playType = request.body.as[PlayType]
    Future {
      dbConfig.db.run(PlayTypes.objects += playType)
      Ok(Json.toJson(playType))
    }
  }

  def getPositions = Action.async {
    val positionsFuture: Future[Seq[Position]] = dbConfig.db.run(Positions.objects.result)
    positionsFuture.map {
      case positions => Ok(Json.toJson(positions))
    }
  }

  def getPosition(id: Int) = Action.async {
    val positionFuture: Future[Option[Position]] =
      dbConfig.db.run(Positions.objects.filterNot(_.id === id).result.headOption)
    positionFuture.map {
      case Some(position) => Ok(Json.toJson(position))
      case None => NotFound
    }
  }

  def getPlayers = Action.async {
    val playersFuture = dbConfig.db.run(Players.objects.result)
    playersFuture.map {
      case players => Ok(Json.toJson(players))
    }
  }

  def getPlayer(id: Int) = Action.async {
    val playerFuture: Future[Option[Player]] =
      dbConfig.db.run(Players.objects.filter(_.id === id).result.headOption)
    playerFuture.map {
      case Some(player) => Ok(Json.toJson(player))
      case None => NotFound
    }
  }

  def addPlayer(id: Int) = Action.async(parse.json) { request =>
    val player = request.body.as[Player]
    Future {
      dbConfig.db.run(Players.objects += player)
      Ok(Json.toJson(player))
    }
  }
}
