Server software for Predators App
=================================

#Installation (OS X)
Install Scala, SBT and TypeSafe Activator
```brew install scala
brew install sbt
brew install typesafe-activator```

Get depencencies
```sbt update```

Create IntelliJ project:
```New Project``` -> ```Import from existing``` -> Choose ```build.sbt``` from  project directory

# Run
CLI:
In project directory run ```activator run```. This also resolves and downloads dependencies.

IntelliJ:
```Run``` -> ```Edit configurations``` -> Add ```Play 2 App``` configuration
