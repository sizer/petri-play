name := "petri"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaJpa,
  cache,
  filters,
  "org.eclipse.persistence" % "eclipselink" % "2.5.2",
  "org.projectlombok" % "lombok" % "1.16.6"
)

play.Project.playJavaSettings
