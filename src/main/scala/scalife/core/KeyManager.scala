package scalife.core

import scala.collection.mutable

class KeyManager {
  private val actions: mutable.HashMap[Char, () => Unit] = mutable.HashMap.empty
  
  def register(key: Char)(action: () => Unit): Unit = {
    if (actions.contains(key)) {
      throw new IllegalArgumentException("Key " + key + " is already registered")
    }
    actions(key) = action
  }
  
  def unregister(key: Char): Unit = {
    if (!actions.contains(key)) {
      throw new IllegalArgumentException("Key " + key + " is not registered")
    }
    actions.remove(key)
  }
  
  def execute(key: Char): Unit = {
    if (!actions.contains(key)) {
      throw new IllegalArgumentException("Key " + key + " is not registered")
    }
    actions(key)()
  }
}
