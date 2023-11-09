import typings.vscode.mod as vscode
import typings.vscode.anon.Dispose
import typings.vscode.Thenable

import scala.collection.immutable
import scala.util.*
import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel
import scala.scalajs.js.UndefOr

import concurrent.ExecutionContext.Implicits.global

object extension {
  @JSExportTopLevel("activate")
  def activate(context: vscode.ExtensionContext): Unit = {

    println(
      """Congratulations, your extension "vscode-scalajs-hello" is now active!"""
    )

    def showHello(): js.Function1[Any, Any] =
      (arg) => {
        vscode.window.showInputBox().toFuture.onComplete {
          case Success(input) => vscode.window.showInformationMessage(s"Hello World $input!")
          case Failure(e)     => println(e.getMessage)
        }
      }

    val commands = List(
      ("extension.helloWorld", showHello())
    )

    commands.foreach { case (name, fun) =>
      context.subscriptions.push(
        vscode.commands
          .registerCommand(name, fun)
          .asInstanceOf[Dispose]
      )
    }

  }
}
