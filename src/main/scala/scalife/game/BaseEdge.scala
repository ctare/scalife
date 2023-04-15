package scalife.game

import processing.core.PVector
import scalife.Main
import scalife.math.graph.Edge

import java.awt.Color

abstract class BaseEdge(
  override val from: BaseNode,
  override val to: BaseNode,
  val color: Color,
)(val width: Float) extends Edge(from, to) {
  def draw(): Unit = {
    Main.canvas.stroke(color.getRed, color.getGreen, color.getBlue, color.getAlpha)
    Main.canvas.strokeWeight(width)
    Main.canvas.line(from.x, from.y, to.x, to.y)
  }
}
