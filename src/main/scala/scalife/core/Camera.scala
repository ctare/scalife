package scalife.core

import processing.core.{PApplet, PVector}
import scalife.Main

class Camera(val width: Int, val height: Int) {
  private var displayScale = 1.0f
  private val displayVec = new PVector(0, 0)

  def zoomOut(scale: Float): Unit = {
    displayVec.x += (this.width / displayScale) / scale
    displayVec.y += (this.height / displayScale) / scale
    displayScale /= scale
  }

  def zoomIn(scale: Float): Unit = {
    displayScale *= scale
    displayVec.x -= (this.width / displayScale) / scale
    displayVec.y -= (this.height / displayScale) / scale
  }

  def move(x: Float, y: Float): Unit = {
    displayVec.x += x / displayScale
    displayVec.y += y / displayScale
  }

  def execute(): Unit = {
    Main.canvas.scale(displayScale)
    Main.canvas.translate(displayVec.x, displayVec.y)
  }

  def position(mouseX: Int, mouseY: Int): PVector = {
    val x = (mouseX / displayScale) - displayVec.x
    val y = (mouseY / displayScale) - displayVec.y
    new PVector(x, y)
  }
}
