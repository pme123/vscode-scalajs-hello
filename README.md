# vscode-scalajs-hello

This Project is a port of the [helloworld-minimal-sample] to [ScalaJS]. It is based on the extension [accessible-scala].

Please check there on how to describe a VSCode Extension.

## Your first Extension
A step-by-step tutorial for **ScalaJS** using this example project.

Here is the original: [visualstudio.com/api/get-started](https://code.visualstudio.com/api/get-started/your-first-extension)

### Setup

* Clone this project:

      git clone https://github.com/pme123/vscode-scalajs-hello.git

* Open VSCode in the `sbt` console:

      open

  This will run `fastOptJS`and then open the Extension Host of _VSCode_.

* Run the Hello World command from the Command Palette (`⇧⌘P`) in the new VSCode window.
* Type `hello` and select `Hello World`.
  * You should see a Notification _Hello World!_.

## Debug your Extension

There seems not to be support for debugging Scala code directly in _VSCode_ (at least I did not find how to do this).

However you can achieve this:

1. Run the extension from VSCode. There is a launch configuration in `.vscode/launch.json`. so just press `F5` and another _VS Code_ window opens in debug mode.
2. You have to set the Breakpoints in the generated Javascript (`out/extension.js`). Through `extension.js.map` the breakpoint will stop in your Scala code.

> If you work in this mode, make sure in your _sbt console_ to transpile to Javascript continuously (`~fastOptJS`). So you see all your changes.

 ## How-To / Further Information
Check out the (vsc-extension-quickstart.md) for some general _VSCode Extension_ explanations.

The project uses the following:
* **ScalaJS** for general coding: [ScalaJS]

  The `extension.js` from [helloworld-minimal-sample], is now `src/main/scala/extension.scala`.

* **ScalablyTyped** for JavaScript facades: [Scalably Typed]

  The Hello World only uses the `vscode` bindings. But you can use any other _Typescript_ binding supported by _ScalablyTyped_.

* **sbt** for building the project: [SBT]
* **scalajs-bundler** for bundling the JavaScript dependencies: [scalajs-bundler].

## Open Points

* Publishing to the Marketplace.
* Add Testing.

[accessible-scala]: https://marketplace.visualstudio.com/items?itemName=scala-center.accessible-scala
[helloworld-minimal-sample]: https://github.com/Microsoft/vscode-extension-samples/tree/master/helloworld-minimal-sample
[Scalably Typed]: https://github.com/oyvindberg/ScalablyTyped
[SBT]: https://www.scala-sbt.org
[ScalaJS]: http://www.scala-js.org
[scalajs-bundler]: https://github.com/scalacenter/scalajs-bundler
