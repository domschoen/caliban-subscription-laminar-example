val V = new {
  val Scala = "3.3.1"

  val laminar = "16.0.0"

  val http4s = "0.23.18"

  val http4sDom = "0.2.8"

  val circe = "0.14.5"

  val decline = "2.4.1"

  val organiseImports = "0.6.0"

  val weaver = "0.8.3"
}

lazy val calibanVersion             = "2.5.0"


val sttpVersion               = "3.9.1"
val jsoniterVersion           = "2.25.0"
val zioVersion                = "2.0.20"
val laminextVersion           = "0.16.2"

val Dependencies = new {
  private val http4sModules =
    Seq("dsl", "ember-client", "ember-server", "circe").map("http4s-" + _)

  private val sttpModules = Seq("core", "circe")

  lazy val frontend = Seq(
    libraryDependencies ++=
      Seq(
        "org.http4s" %%% "http4s-client" % V.http4s,
        "org.http4s" %%% "http4s-circe"  % V.http4s,
        "org.http4s" %%% "http4s-dom"    % V.http4sDom,
        "com.raquo"  %%% "laminar"       % V.laminar,
  "com.github.ghostdogpr" %%% "caliban-client-laminext" % "2.5.0",
  "io.laminext"                           %%% "core"                % laminextVersion,
  "io.laminext"                           %%% "fetch"               % laminextVersion,
  "io.laminext"                           %%% "websocket"           % laminextVersion,
  "com.softwaremill.sttp.client3"        %%% "core"                  % sttpVersion,
  "com.softwaremill.sttp.client3"        %%% "jsoniter"              % sttpVersion,
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-core"   % jsoniterVersion,
  "com.github.plokhotnyuk.jsoniter-scala" %% "jsoniter-scala-macros" % jsoniterVersion % Provided,
  "dev.zio"                              %%% "zio-test"              % zioVersion      % Test,
  "dev.zio"                              %%% "zio-test-sbt"          % zioVersion      % Test,
  "com.github.ghostdogpr" %%% "caliban-client" % calibanVersion
      )
  )

  lazy val catsEffectVersion          = "3.3.14"
  lazy val circeVersion               = "0.14.0"
  lazy val http4sVersion              = "0.23.18"
  lazy val doobieVersion              = "1.0.0-RC1"
  lazy val pureConfigVersion          = "0.17.4"
  lazy val log4catsVersion            = "2.4.0"
  lazy val tsecVersion                = "0.4.0"
  lazy val scalaTestVersion           = "3.2.12"
  lazy val scalaTestCatsEffectVersion = "1.4.0"
  lazy val testContainerVersion       = "1.17.3"
  lazy val logbackVersion             = "1.4.0"
  lazy val slf4jVersion               = "2.0.0"
  lazy val javaMailVersion            = "1.6.2"
  lazy val mongoDBVersion             = "0.6.15"


  lazy val backend = Seq(
    libraryDependencies ++= Seq(
      "org.typelevel"         %% "cats-effect"         % catsEffectVersion,
      "org.http4s"            %% "http4s-dsl"          % http4sVersion,
      "org.http4s"            %% "http4s-ember-server" % http4sVersion,
      "org.http4s"            %% "http4s-ember-client" % http4sVersion,
      "org.http4s"            %% "http4s-client"       % http4sVersion,
      "org.http4s"            %% "http4s-circe"        % http4sVersion,
      //"org.http4s" %% _ % V.http4s,
      "com.monovore" %% "decline" % V.decline,

      "dev.zio"                     %% "zio-interop-cats" % "3.1.1.0",
      "dev.zio"                     %% "zio"              % "2.0.20",
      "com.github.ghostdogpr"         %% "caliban"                       % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-quick"                 % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-http4s"                % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-pekko-http"            % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-zio-http"              % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-cats"                  % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-federation"            % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-tapir"                 % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-client"                % calibanVersion,
      "com.github.ghostdogpr"         %% "caliban-tools"                 % calibanVersion,
      "org.http4s"                    %% "http4s-ember-server"           % "0.23.23",
      "org.http4s"                    %% "http4s-dsl"                    % "0.23.23",
      "com.softwaremill.sttp.client3" %% "zio"                           % "3.9.0",

      "com.softwaremill.sttp.tapir" %% "tapir-json-circe" % "1.2.11", // Circe
      "io.circe"              %% "circe-fs2"           % "0.14.1",
      "io.circe" %% "circe-core"                   % circeVersion,
      "io.circe" %% "circe-generic"                % circeVersion,
      "io.circe" %% "circe-parser"                 % circeVersion,

      "org.tpolecat"          %% "doobie-core"         % doobieVersion,
      "org.tpolecat"          %% "doobie-hikari"       % doobieVersion,
      "org.tpolecat"          %% "doobie-postgres"     % doobieVersion,
      "org.tpolecat"          %% "doobie-scalatest"    % doobieVersion    % Test,

      "com.github.pureconfig" %% "pureconfig-core"     % pureConfigVersion,

      "org.typelevel"         %% "log4cats-slf4j"      % log4catsVersion,
      "org.slf4j"              % "slf4j-simple"        % slf4jVersion,
      "io.github.jmcardon"    %% "tsec-http4s"         % tsecVersion,
      "com.sun.mail"           % "javax.mail"          % javaMailVersion,
      "org.typelevel"         %% "log4cats-noop"       % log4catsVersion  % Test,
      "org.scalatest"         %% "scalatest"           % scalaTestVersion % Test,
      "org.typelevel"     %% "cats-effect-testing-scalatest" % scalaTestCatsEffectVersion % Test,
      "org.testcontainers" % "testcontainers"                % testContainerVersion       % Test,
      "org.testcontainers" % "postgresql"                    % testContainerVersion       % Test,
      "ch.qos.logback"     % "logback-classic"               % logbackVersion             % Test
    )
  )

  lazy val shared = Def.settings(
    libraryDependencies += "io.circe" %%% "circe-core" % V.circe
  )

  lazy val tests = Def.settings(
    libraryDependencies += "com.disneystreaming" %%% "weaver-cats" % V.weaver % Test,
    testFrameworks += new TestFramework("weaver.framework.CatsEffect")
  )
}

inThisBuild(
  Seq(
    scalafixDependencies += "com.github.liancheng" %% "organize-imports" % V.organiseImports,
    semanticdbEnabled := true,
    semanticdbVersion := scalafixSemanticdb.revision
  )
)

lazy val root =
  project.in(file(".")).aggregate(frontend, backend, shared.js, shared.jvm)

lazy val frontend = project
  .in(file("modules/frontend"))
  .dependsOn(shared.js)
  .enablePlugins(ScalaJSPlugin)
  .settings(scalaJSUseMainModuleInitializer := true)
  .settings(
    Dependencies.frontend,
    Dependencies.tests,
    Test / jsEnv := new org.scalajs.jsenv.jsdomnodejs.JSDOMNodeJSEnv()
  )
  .settings(commonBuildSettings)

lazy val backend = project
  .in(file("modules/backend"))
  .dependsOn(shared.jvm)
  .settings(Dependencies.backend)
  .settings(Dependencies.tests)
  .settings(commonBuildSettings)
  .enablePlugins(JavaAppPackaging)
  .enablePlugins(DockerPlugin)
  .settings(
    Test / fork := true,
    Docker / mappings += {
      val appJs = (frontend / Compile / fullOptJS).value.data
      appJs -> "/opt/docker/resources/prod.js"
    },
    Universal / javaOptions ++= Seq(
      "--port 8080",
      "--mode prod"
    ),
    Docker / packageName := "caliban-subscription-laminar-example"
  )

lazy val shared = crossProject(JSPlatform, JVMPlatform)
  .crossType(CrossType.Pure)
  .in(file("modules/shared"))
  .jvmSettings(Dependencies.shared)
  .jsSettings(Dependencies.shared)
  .jsSettings(commonBuildSettings)
  .jvmSettings(commonBuildSettings)

lazy val fastOptCompileCopy = taskKey[Unit]("")

val jsPath = "modules/backend/src/main/resources"

fastOptCompileCopy := {
  val source = (frontend / Compile / fastOptJS).value.data
  IO.copyFile(
    source,
    baseDirectory.value / jsPath / "dev.js"
  )
}

lazy val fullOptCompileCopy = taskKey[Unit]("")

fullOptCompileCopy := {
  val source = (frontend / Compile / fullOptJS).value.data
  IO.copyFile(
    source,
    baseDirectory.value / jsPath / "prod.js"
  )

}

lazy val commonBuildSettings: Seq[Def.Setting[?]] = Seq(
  scalaVersion := V.Scala
)

addCommandAlias("runDev", ";fastOptCompileCopy; backend/reStart --mode dev")
addCommandAlias("runProd", ";fullOptCompileCopy; backend/reStart --mode prod")

val scalafixRules = Seq(
  "OrganizeImports",
  "DisableSyntax",
  "LeakingImplicitClassVal",
  "NoValInForComprehension"
).mkString(" ")

val CICommands = Seq(
  "clean",
  "backend/compile",
  "backend/test",
  "frontend/compile",
  "frontend/fastOptJS",
  "frontend/test",
  "scalafmtCheckAll",
  s"scalafix --check $scalafixRules"
).mkString(";")

val PrepareCICommands = Seq(
  "scalafmtAll",
  "scalafmtSbt",
  s"scalafix $scalafixRules"
).mkString(";")

addCommandAlias("ci", CICommands)

addCommandAlias("preCI", PrepareCICommands)
