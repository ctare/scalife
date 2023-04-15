package scalife.mods.simple.nodes

import scalife.game.BaseNode

import java.awt.Color

class FoodNode(
  val capacity: Float,
  override val x: Float,
  override val y: Float,
) extends BaseNode(new Color(223, 226, 38))(x, y, capacity * 2) with Resource {
}
