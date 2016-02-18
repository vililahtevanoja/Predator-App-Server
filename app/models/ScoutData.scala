package models
/**
  * Created on 2016-02-16.
  *
  * @author vili
  */
import sorm._
import play.api.libs.json.{Format, JsPath, JsValue, Writes, Json}
import play.api.libs.functional.syntax._

case class Formation(val name: String)

object Formation {
  implicit val format = Json.format[Formation]
}

case class PlayType(val name: String)

object PlayType {
  implicit val format = Json.format[PlayType]
}

case class Player(number: Int)

object Player {
  implicit val format = Json.format[Player]
}

case class Position(val name: String)

object Position {
  implicit val format = Json.format[Position]
}


case class PlayInformation(val name: String,
                           val playType: PlayType)

object PlayInformation {
  implicit val format = Json.format[PlayInformation]
}

case class DownInformation(val name: String,
                           val down: Int,
                           val yards: Int,
                           val gained: Int,
                           val formation: Formation,
                           val play: PlayInformation,
                           val target: Player)

object DownInformation {
  implicit val format = Json.format[DownInformation]
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
