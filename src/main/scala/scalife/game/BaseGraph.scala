package scalife.game

import scalife.core.ui.Drawable
import scalife.math.graph.Graph

class BaseGraph(nodes: Seq[BaseNode], edges: Seq[BaseEdge]) extends Graph(nodes, edges), Drawable {

  def draw(): Unit = {
    edges.foreach(_.draw())
    nodes.foreach(_.draw())
  }
}
