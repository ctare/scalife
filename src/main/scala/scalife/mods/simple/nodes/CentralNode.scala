package scalife.mods.simple.nodes

import scalife.game.BaseNode
import scalife.math.graph.Edge

import java.awt.Color

class CentralNode(
  override val x: Float,
  override val y: Float,
) extends BaseNode(new Color(255, 255, 255))(x, y, 300) {

}
