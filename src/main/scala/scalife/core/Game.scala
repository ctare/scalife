package scalife.core

class Game(val width: Int, val height: Int) {
  val camera = new Camera(width, height)
  val keyManager = new KeyManager
}
