package scalife

import processing.core.PApplet

object Main:
  def main(args: Array[String]): Unit = {
    PApplet.main("scalife.Main")
  }

class Main extends PApplet:
  override def settings(): Unit = {
    size(700, 700)
  }

  override def setup(): Unit = {
    surface.setIcon(loadImage("logo.png"))
    surface.setTitle("Scalife")
  }

  override def draw(): Unit = {
    background(0)
    ellipse(mouseX, mouseY, 50, 50)
    fill(255)
  }
