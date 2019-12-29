
import vscode.{ExtensionContext}

import scala.scalajs.js
import scala.scalajs.js.annotation.JSExportTopLevel

object extension {
  @JSExportTopLevel("activate")
  def activate(context: ExtensionContext): Unit = {

    println("""Congratulations, your extension "vscode-scalajs-hello" is now active!""")
    
    def showHello(): js.Function =
		() => vscode.window.showInformationMessage("Hello VS Code!")

    val commands = List(
      ("extension.helloWorld", showHello())
      )
          println(s"""commands $commands""")

    commands.foreach {
      case (name, fun) =>
          println(s"""added $name""")
        context.subscriptions.push(
          vscode.commands.registerCommand(name, fun)
        )
    }


  }
}