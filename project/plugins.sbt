addSbtPlugin("org.scala-js" % "sbt-scalajs" % "0.6.31")
addSbtPlugin("ch.epfl.scala" % "sbt-scalajs-bundler-sjs06" % "0.16.0")

resolvers += Resolver.bintrayRepo("oyvindberg", "ScalablyTyped")
addSbtPlugin("org.scalablytyped" % "sbt-scalablytyped" % "201912161031")
