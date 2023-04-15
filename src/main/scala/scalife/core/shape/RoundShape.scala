package scalife.core.shape

import processing.core.PApplet

trait RoundShape {
  def x: Float
  def y: Float
  def r: Float
}

object RoundShape {
  def isHit(x1: Float, y1: Float, r1: Float, x2: Float, y2: Float, r2: Float): Boolean = PApplet.dist(x1, y1, x2, y2) <= r1 + r2
  def isHit(s1: RoundShape, s2: RoundShape): Boolean = isHit(s1.x, s1.y, s1.r, s2.x, s2.y, s2.r)
}
