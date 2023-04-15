package scalife.core.database

import scalife.math.graph.{Node, Edge}

class DBGraph[N <: Node, E <: Edge] extends DatabaseValue {
  val nodes = new collection.mutable.ArrayBuffer[N]
  val edges = new collection.mutable.ArrayBuffer[E]

  def addRootNode(node: N): Unit = nodes += node
  def addNode(from: N, node: N, edgeBuilder: (N, N) => E): Unit = {
    nodes += node
    edges += edgeBuilder(from, node)
  }

  def removeNode(node: N): Unit = {
    nodes -= node
    edges --= edges.filter(e => e.from == node || e.to == node)
  }
}
