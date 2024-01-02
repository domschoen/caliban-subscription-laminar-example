package example.frontend

import com.raquo.laminar.api.L.*
import org.scalajs.dom

object Main:


  def main(args: Array[String]): Unit =
    windowEvents(_.onLoad).foreach { _ =>
      render(dom.document.getElementById("appContainer"), Page.view)
    }(unsafeWindowOwner)
end Main
