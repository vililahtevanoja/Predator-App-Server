package models
/**
  * Created on 2016-02-16.
  *
  * @author vili
  */
import sorm._
import play.api.libs.json.{JsValue, Writes, Json}

case class Formation(val name: String)

object Formation {
  implicit val writes = Json.writes[Formation]
  implicit val reads = Json.reads[Formation]
}

case class PlayInformation(val name: String,
                           val playType: PlayType)

object PlayInformation {
  implicit val writes = Json.writes[PlayInformation]
//  implicit val playInformationWrites = new Writes[PlayInformation with Persisted] {
//    def writes(play: PlayInformation with Persisted): JsValue = {
//      Json.obj(
//        "id" -> play.id,
//        "playType" -> play.playType
//      )
//    }
//  }
  implicit val reads = Json.reads[PlayInformation]
}

case class Player(number: Int)

object Player {
  implicit val writes = Json.writes[Player]
  implicit val reads = Json.reads[Player]
}

case class PlayType(val name: String)

object PlayType {
  implicit val writes = Json.writes[PlayType]
  implicit val reads = Json.reads[PlayType]
}

case class Position(val name: String)

object Position {
  implicit val writes = Json.writes[Position]
  implicit val reads = Json.reads[Position]
}

case class DownInformation(val name: String,
                           val down: Int,
                           val yards: Int,
                           val gained: Int,
                           val formation: Formation,
                           val play: PlayInformation,
                           val target: Player)

object DownInformation {
  implicit val writes = Json.writes[DownInformation]
  implicit val reads = Json.reads[DownInformation]
}

object ScoutDataDb extends Instance (
  entities = Set(
    Entity[Formation](),
    Entity[PlayInformation](),
    Entity[Player](),
    Entity[PlayType](),
    Entity[Position](),
    Entity[DownInformation]()
  ),
  url = "jdbc:h2:mem:test",
  user = "",
  password = "",
  initMode = InitMode.Create,
  poolSize = 12
)
