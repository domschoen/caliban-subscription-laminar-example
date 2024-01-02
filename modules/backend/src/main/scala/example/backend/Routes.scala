package example.backend

import scala.concurrent.duration.*

import zio._
import zio.interop.catz._
import zio.interop.catz.implicits._

import org.http4s._
import org.http4s.dsl.Http4sDsl
import org.http4s.implicits._

import org.http4s.HttpRoutes
import org.http4s.StaticFile
import org.http4s.circe.CirceEntityDecoder
import org.http4s.circe.CirceEntityDecoder.*
import org.http4s.circe.CirceEntityEncoder.*
import org.http4s.dsl.Http4sDsl

import example.shared.Protocol.*

class Routes(
    frontendJS: String
) extends Http4sDsl[Task]:
  def routes = HttpRoutes.of[Task] {


    case request @ GET -> Root / "frontend" / "app.js" =>
      StaticFile
        .fromResource[Task](frontendJS, Some(request))
        .getOrElseF(NotFound())

    case request @ GET -> Root / "frontend" =>
      StaticFile
        .fromResource[Task]("index.html", Some(request))
        .getOrElseF(NotFound())

    case request @ GET -> Root / "assets" / path if staticFileAllowed(path) =>
      StaticFile
        .fromResource("/assets/" + path, Some(request))
        .getOrElseF(NotFound())
  }

  private def staticFileAllowed(path: String) =
    List(".gif", ".js", ".css", ".map", ".html", ".webm").exists(path.endsWith)
end Routes
