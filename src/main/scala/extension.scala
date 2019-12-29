import typings.vscode
import typings.vscode.{Anon_Dispose, Thenable, vscodeMod}
import typings.vscode.vscodeMod.ExtensionContext

import scala.collection.immutable
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.scalajs.js.UndefOr

object extension {
  @JSExportTopLevel("activate")
  def activate(context: ExtensionContext): Unit = {

    println(
      """Congratulations, your extension "vscode-scalajs-hello" is now active!"""
    )

    def showHello(): js.Function1[js.Any, Thenable[UndefOr[String]]] =
      in => vscodeMod.window.showInformationMessage(s"Hello World $in!")

    val commands = List(
      ("extension.helloWorld", showHello())
    )

    commands.foreach {
      case (name, fun) =>
        context.subscriptions.push(
          vscodeMod.commands
            .registerCommand(name, fun)
            .asInstanceOf[Anon_Dispose]
        )
    }

  }
}
