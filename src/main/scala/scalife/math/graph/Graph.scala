package scalife.math.graph

import scalife.core.ui.Drawable

/**
 * 隣接行列からグラフを作成する
 * @param nodes ノードの配列
 * @param edges エッジの配列
 */
trait Graph[N <: Node, E <: Edge](val nodes: Seq[N], val edges: Seq[E]) {

}
