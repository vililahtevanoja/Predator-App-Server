import dao._
import models.{Position, PlayType, Formation}
import play.api.{Application, GlobalSettings}
import slick.driver.H2Driver.api._


object Global extends GlobalSettings {

  override def onStart(app: Application) = {
    loadTestData
  }

  def loadTestData = {
    val db = Database.forConfig("h2mem1")
    db.run(
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