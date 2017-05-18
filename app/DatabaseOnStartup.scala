import dao._
import models._
import javax.inject._

import play.api.db.slick.DatabaseConfigProvider
import slick.driver.H2Driver.api._
import slick.driver.JdbcProfile

import scala.concurrent.Await
import scala.concurrent.duration._
//import slick.driver.PostgresDriver.api._

@Singleton
class DatabaseOnStartup @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  import dbConfig.driver.api._

  @Inject
  def DatabaseOnStartup() = {

//    Database
//      .forConfig("h2mem1")
    val dbInitiate = dbConfig
      .db
      .run(
        DBIO.seq(
          PlayInformations.objects.schema.create,
          DownInformations.objects.schema.create,
          Formations.objects.schema.create,
          Formations.objects += Formation(None, "Split"),
          Formations.objects += Formation(None, "Slot"),
          Formations.objects += Formation(None, "Ace"),
          Formations.objects += Formation(None, "I"),
          Formations.objects += Formation(None, "Triple"),
          PlayTypes.objects.schema.create,
          PlayTypes.objects += PlayType(None, "Run"),
          PlayTypes.objects += PlayType(None, "Pass"),
          Positions.objects.schema.create,
          Positions.objects += Position(None, "OL"),
          Positions.objects += Position(None, "QB"),
          Positions.objects += Position(None, "RB"),
          Positions.objects += Position(None, "WR"),
          Positions.objects += Position(None, "TE"),
          Positions.objects += Position(None, "DL"),
          Positions.objects += Position(None, "LB"),
          Positions.objects += Position(None, "CB"),
          Positions.objects += Position(None, "S"),
          Teams.objects.schema.create,
          Teams.objects += Team(Some(1), "Aalto Predators"),
          Teams.objects += Team(Some(2), "Lappeenranta Wildmen"),
          Players.objects.schema.create,
          Players.objects += Player(Some(1), 1, 66),
          Players.objects += Player(Some(2), 1, 69)
        )
      )
    Await.ready(dbInitiate, 10000 millis)
  }
}