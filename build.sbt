name := "petri"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  filters,
  "org.projectlombok" % "lombok" % "1.16.6"
)

play.Project.playJavaSettings
