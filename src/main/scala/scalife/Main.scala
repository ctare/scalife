package scalife

import processing.core.PApplet
import scalife.core.Game

object Main {
  def main(args: Array[String]): Unit = {
    PApplet.main("scalife.Main")
  }
}

class Main extends PApplet {
  private lazy val game: Game = new Game(this.width, this.height)
  override def settings(): Unit = {
    size(700, 700)
  }

  override def setup(): Unit = {
    surface.setIcon(loadImage("logo.png"))
    surface.setTitle("Scalife")

    game.camera.execute(this)

    game.keyManager.register('j') { () => game.camera.zoomOut(2) }
    game.keyManager.register('k') { () => game.camera.zoomIn(2) }
  }

  override def draw(): Unit = {
    game.camera.execute(this)

    background(0)
    ellipse(100, 100, 50, 50)
    fill(255)

    if (mousePressed) {
      game.camera.move(mouseX - pmouseX, mouseY - pmouseY)
    }
  }

  override def keyPressed(): Unit = {
    game.keyManager.execute(key)
  }
}
