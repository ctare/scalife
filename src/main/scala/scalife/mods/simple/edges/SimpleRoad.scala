package scalife.mods.simple.edges

import scalife.game.{BaseEdge, BaseNode}

import java.awt.Color

class SimpleRoad(
  override val from: BaseNode,
  override val to: BaseNode,
) extends BaseEdge(from, to, new Color(255, 255, 255, 100))(10) {

}
