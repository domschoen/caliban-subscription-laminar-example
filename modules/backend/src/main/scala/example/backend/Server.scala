package example.backend

import cats.effect.*
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits.*
import org.http4s.server.middleware.GZip
import zio._
import zio.interop.catz._
import fs2.io.net.Network
import caliban.{GraphQL, Http4sAdapter}
import caliban.interop.tapir.{HttpInterpreter, WebSocketInterpreter}
import cats.data.Kleisli
import com.comcast.ip4s._
import example.backend.ExampleData._
import example.backend.{ExampleApi, ExampleService}

import org.http4s.StaticFile
import org.http4s.ember.server.EmberServerBuilder
import org.http4s.implicits._
import org.http4s.server.Router
import org.http4s.server.middleware.CORS


object Server extends ZIOAppDefault {
  import sttp.tapir.json.circe._

  private implicit val network: Network[Task] = Network.forAsync


  override def run: ZIO[Scope, Throwable, Unit] =
    (for {
      interpreter <- ZIO.serviceWithZIO[GraphQL[Any]](_.interpreter)
      routes     = new Routes("dev.js").routes

      app = GZip(routes)
      _           <- EmberServerBuilder
        .default[Task]
        .withHost(host"0.0.0.0")
        .withPort(port"9000")
        //.withHttpApp(app.orNotFound)
        .withHttpWebSocketApp(wsBuilder =>
          Router[Task](
            "/api/graphql" -> CORS.policy(Http4sAdapter.makeHttpService(HttpInterpreter(interpreter))),
            "/ws/graphql"  -> CORS.policy(
              Http4sAdapter.makeWebSocketService(wsBuilder, WebSocketInterpreter(interpreter))
            ),
            "/graphiql"    -> Kleisli.liftF(StaticFile.fromResource("/graphiql.html", None)),
            "/"            -> new Routes("dev.js").routes

        ).orNotFound
        )
        .build
        .toScopedZIO
      _           <- Console.printLine("Server online at http://localhost:9000/\nPress RETURN to stop...")
      _           <- Console.readLine
    } yield ())
      .provideSome[Scope](ExampleService.make(sampleCharacters), ExampleApi.layer)
}
