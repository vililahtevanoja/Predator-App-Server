import javax.inject.Inject

import dao._
import models.{Position, Formation, PlayType}
import play.api.db.slick.DatabaseConfigProvider
import slick.driver.JdbcProfile

class TestData @Inject()(dbConfigProvider: DatabaseConfigProvider) {
  val dbConfig = dbConfigProvider.get[JdbcProfile]
  import dbConfig.driver.api._
  def load = {
    dbConfig.db.run(
      DBIO.seq(
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
        PlayInformations.objects.schema.create,
        DownInformations.objects.schema.create,
        Players.objects.schema.create
      )
    )
  }
}
