package scalife.mods.simple.nodes

import scalife.game.BaseNode
import scalife.math.graph.Node

trait Resource {
  val capacity: Float
  var grow: Float = 0
}
