import scala.sys.process._

lazy val scalajsSettings = Seq(
  scalacOptions += "-P:scalajs:sjsDefinedByDefault"
)

lazy val installDependencies = Def.task[Unit] {
  val base = (baseDirectory in ThisProject).value
  val log = (streams in ThisProject).value.log
  if (!(base / "node_module").exists) {
    val pb =
      new java.lang.ProcessBuilder("npm", "install")
        .directory(base)
        .redirectErrorStream(true)

    pb ! log
  }
}

lazy val open = taskKey[Unit]("open vscode")
def openVSCodeTask: Def.Initialize[Task[Unit]] =
  Def
    .task[Unit] {
      val base = (baseDirectory in ThisProject).value
      val log = (streams in ThisProject).value.log

      val path = base.getCanonicalPath
      s"code --extensionDevelopmentPath=$path" ! log
      ()
    }
    .dependsOn(installDependencies)

lazy val root = project
  .in(file("."))
  .settings(scalajsSettings)
  .settings(
    scalaVersion := "2.12.10",
    moduleName := "vscode-scalajs-hello",
    scalacOptions += "-P:scalajs:sjsDefinedByDefault",
    scalaJSModuleKind := ModuleKind.CommonJSModule,
    artifactPath in (Compile, fastOptJS) := baseDirectory.value / "out" / "extension.js",
    artifactPath in (Compile, fullOptJS) := baseDirectory.value / "out" / "extension.js",
    open := openVSCodeTask.dependsOn(fastOptJS in Compile).value,
    libraryDependencies ++= Seq(
      ScalablyTyped.V.`vscode`,
      "com.lihaoyi" %%% "utest" % "0.7.1" % "test"
    ),
    npmDependencies in Compile ++= Seq("vscode" -> "1.41"),
    testFrameworks += new TestFramework("utest.runner.Framework")
    // publishMarketplace := publishMarketplaceTask.dependsOn(fullOptJS in Compile).value
  )
  .enablePlugins(ScalaJSPlugin, ScalaJSBundlerPlugin)
