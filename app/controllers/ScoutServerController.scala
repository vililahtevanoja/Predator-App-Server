package controllers

import models._
import play.api._
import play.api.libs.json.Json
import play.api.mvc._

class ScoutServerController extends Controller {

  def index = Action {
    Ok("Hello, world. You're at the polls index.")
  }

  def getFormation(id: Long) = Action {
    val formation = ScoutDataDb.fetchById[Formation](id)
    Ok(Json.toJson(formation))
  }

  def getFormations = Action {
    val formations = ScoutDataDb.query[Formation].fetch()
    Ok(Json.toJson(formations))
  }

  def addFormation = Action(parse.json) { request =>
    val formation = ScoutDataDb.save(request.body.as[Formation])
    Ok(Json.toJson(formation))
  }

  def getPlay(id: Long) = Action {
    val play = ScoutDataDb.fetchById[PlayInformation](id)
    Ok(Json.toJson(play))
  }

  def getPlays = Action {
    val plays = ScoutDataDb.query[PlayInformation].fetch()
    Ok(Json.toJson(plays))
  }

  def addPlay = Action(parse.json) { request =>
    val formation = ScoutDataDb.save(request.body.as[PlayInformation])
    Ok(Json.toJson(formation))
  }

  def getDown(id: Long) = Action {
    val down = ScoutDataDb.fetchById[DownInformation](id)
    Ok(Json.toJson(down))
  }

  def getDowns = Action {
    val downs = ScoutDataDb.query[DownInformation].fetch()
    Ok(Json.toJson(downs))
  }

  def addDown = Action(parse.json) {request =>
    val down = ScoutDataDb.save(request.body.as[DownInformation])
    Ok(Json.toJson(down))
  }

  def getPlayType(id: Long) = Action {
    val playType = ScoutDataDb.fetchById[PlayType](id)
    Ok(Json.toJson(playType))
  }

  def getPlayTypes = Action {
    val playTypes = ScoutDataDb.query[PlayType].fetch()
    Ok(Json.toJson(playTypes))
  }

  def addPlayType = Action(parse.json) { request =>
    val playType = ScoutDataDb.save(request.body.as[PlayType])
    Ok(Json.toJson(playType))
  }

}
