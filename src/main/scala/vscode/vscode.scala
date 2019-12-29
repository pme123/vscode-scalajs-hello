package vscode

import scala.scalajs.js
import scala.scalajs.js.annotation._

@js.native
@JSImport("vscode", "window")
object window extends js.Object {
  def activeTextEditor: TextEditor = js.native
  def showInformationMessage(message: String): Unit = js.native
}

@js.native
@JSImport("vscode", "commands")
object commands extends js.Object {
  def registerCommand(command: String, callback: js.Function): Disposable =
    js.native
}

@js.native
@JSImport("vscode", "Selection")
class Selection protected () extends Range {
  def this(anchor: Position, active: Position) = this()
  var anchor: Position = js.native
  var active: Position = js.native
}

@js.native
@JSImport("vscode", "Range")
class Range protected () extends js.Object {
  def this(start: Position, end: Position) = this()
  def start: Position = js.native
  def end: Position = js.native
}

@js.native
@JSImport("vscode", "Position")
class Position protected () extends js.Object {
  def this(line: Double, character: Double) = this()
  def line: Double = js.native
  def character: Double = js.native
}

@js.native
@JSImport("vscode", "Disposable")
class Disposable protected () extends js.Object {
  def this(callOnDispose: js.Function) = this()
  def dispose(): js.Dynamic = js.native
}

@js.native
trait TextEditor extends js.Object {
  val document: TextDocument
  var selection: Selection
  val selections: js.Array[Selection]
}

@js.native
trait TextDocument extends js.Object {
  def getText(): String
  def getText(range: Range): String
  def offsetAt(position: Position): Int
  def positionAt(offset: Int): Position
}

@js.native
trait Event[T] extends js.Object {
  def apply(listener: js.Function1[T, Any]): Unit
}

trait ExtensionContext extends js.Object {
  val subscriptions: js.Array[js.Any]
}
