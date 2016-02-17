Server software for Predators App
=================================

# Installation (OS X)
Install Scala and SBT
```
brew install scala
brew install sbt
```

Resolve and retrieve external dependencies
```
sbt update
```

Create IntelliJ project:
`New Project` -> `Import from existing` -> Choose `build.sbt` from  project directory

# Run
CLI:
Install TypeSafe Activator
```
brew install typesafe-activator
```
In project directory run `activator run`. This also resolves and retrieves dependencies.

IntelliJ:
`Run` -> `Edit configurations` -> Add `Play 2 App` configuration
