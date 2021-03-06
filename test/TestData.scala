import javax.inject.Inject

import dao._
import models._
import java.sql.Date

import org.joda.time.DateTime
import play.api.db.slick.DatabaseConfigProvider
import slick.backend.DatabaseConfig
import slick.driver.JdbcProfile

import scala.concurrent.Future

class TestData @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val dbConfig: DatabaseConfig[JdbcProfile] = dbConfigProvider.get[JdbcProfile]
  import dbConfig.driver.api._
  def load: Future[Unit] = {
    dbConfig.db.run(
      DBIO.seq(
        Formations.objects.schema.create,
        PlayTypes.objects.schema.create,
        Positions.objects.schema.create,
        Teams.objects.schema.create,
        PlayInformations.objects.schema.create,
        DownInformations.objects.schema.create,
        Players.objects.schema.create,
        Games.objects.schema.create,
        Formations.objects += Formation(None, "Split"),
        Formations.objects += Formation(None, "Slot"),
        Formations.objects += Formation(None, "Ace"),
        Formations.objects += Formation(None, "I"),
        Formations.objects += Formation(None, "Triple"),
        PlayTypes.objects += PlayType(None, "Run"),
        PlayTypes.objects += PlayType(None, "Pass"),
        Positions.objects += Position(None, "OL"),
        Positions.objects += Position(None, "QB"),
        Positions.objects += Position(None, "RB"),
        Positions.objects += Position(None, "WR"),
        Positions.objects += Position(None, "TE"),
        Positions.objects += Position(None, "DL"),
        Positions.objects += Position(None, "LB"),
        Positions.objects += Position(None, "CB"),
        Positions.objects += Position(None, "S"),
        Teams.objects += Team(Some(1), "Aalto Predators"),
        Teams.objects += Team(Some(2), "Lappeenranta Wildmen"),
        Players.objects += Player(Some(1), 1, 66),
        Players.objects += Player(Some(2), 1, 69),
        Games.objects += Game(Some(1), 1, 2, new Date(DateTime.now().getMillis))
      )
    )
  }
}
