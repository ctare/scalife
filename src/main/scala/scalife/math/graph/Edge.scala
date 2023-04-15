package scalife.math.graph

import scalife.core.ui.Drawable

import java.awt.Color

/**
 * グラフのエッジを表すクラス
 * @param from エッジの始点
 * @param to エッジの終点
 */
trait Edge(val from: Node, val to: Node) {
}
