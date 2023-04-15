package scalife

import processing.core.PApplet
import scalife.core.Game
import scalife.core.database.{DBGraph, Database}
import scalife.game.{BaseEdge, BaseGraph, BaseNode}
import scalife.math.graph.{Edge, Graph}
import scalife.mods.simple.edges.SimpleRoad
import scalife.mods.simple.nodes.{CentralNode, FoodNode}

object Main {
  private var _canvas: Option[Main] = None
  lazy val canvas: Main = _canvas.getOrElse(throw new RuntimeException("Canvas not initialized"))
  def main(args: Array[String]): Unit = {
    PApplet.main("scalife.Main")
  }
}


class Main extends PApplet {
  //--- tmp values
  case class DatabaseEntity(
    graph: DBGraph[BaseNode, BaseEdge] = new DBGraph[BaseNode, BaseEdge](),
  ) extends Database

  val database: DatabaseEntity = DatabaseEntity()
  // seed
  database.graph.addRootNode(new CentralNode(350, 350))

  //--- tmp end

  private lazy val game: Game = new Game(this.width, this.height)
  override def settings(): Unit = {
    size(700, 700)
  }

  override def setup(): Unit = {
    Main._canvas = Some(this)

    surface.setIcon(loadImage("logo.png"))
    surface.setTitle("Scalife")

    game.camera.execute()

    game.keyManager.register('j') { () => game.camera.zoomOut(2) }
    game.keyManager.register('k') { () => game.camera.zoomIn(2) }
    game.keyManager.register('a') { () =>
      val mousePositionByCamera = game.camera.position(mouseX, mouseY)
      database.graph.addNode(
        database.graph.nodes(0),
        new FoodNode(50, mousePositionByCamera.x, mousePositionByCamera.y),
        (fnode, tnode) => new SimpleRoad(fnode, tnode)
      )
    }
  }

  override def draw(): Unit = {
    game.camera.execute()
    smooth()

    background(0)
    new BaseGraph(database.graph.nodes.toSeq, database.graph.edges.toSeq).draw()

    if (mousePressed) {
      game.camera.move(mouseX - pmouseX, mouseY - pmouseY)
    }
  }

  override def keyPressed(): Unit = {
    game.keyManager.execute(key)
  }
}
