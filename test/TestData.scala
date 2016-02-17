import models.{PlayInformation, PlayType, Formation, ScoutDataDb}

/**
  * Created on 2016-02-17.
  *
  * @author vili
  */
object TestData {
  def load = {
    ScoutDataDb.save(Formation("Split"))
    ScoutDataDb.save(Formation("Slot"))
    ScoutDataDb.save(Formation("Ace"))
    ScoutDataDb.save(Formation("I"))
    ScoutDataDb.save(Formation("Triple"))

    val run = ScoutDataDb.save(PlayType("Run"))
    val pass = ScoutDataDb.save(PlayType("Pass"))

    ScoutDataDb.save(PlayInformation("Toss", run))
    ScoutDataDb.save(PlayInformation("Lead", run))
    ScoutDataDb.save(PlayInformation("Dive", run))
    ScoutDataDb.save(PlayInformation("Hail Mary", pass))
  }
}
