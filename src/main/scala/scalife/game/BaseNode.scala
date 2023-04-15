package scalife.game

import scalife.Main
import scalife.core.shape.RoundShape
import scalife.core.ui.Drawable
import scalife.math.graph.Node
import scalife.mods.simple.edges.SimpleRoad

import java.awt.Color

abstract class BaseNode(
  val color: Color,
)(val x: Float, val y: Float, val r: Float) extends Node, Drawable, RoundShape {
  def draw(): Unit = {
    Main.canvas.noStroke()
    Main.canvas.fill(this.color.getRed, this.color.getGreen, this.color.getBlue, this.color.getAlpha)
    Main.canvas.ellipse(x, y, r, r)
  }
}
