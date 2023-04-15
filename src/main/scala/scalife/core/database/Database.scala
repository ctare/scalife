package scalife.core.database

class Database {
  val values = new scala.collection.mutable.HashMap[String, DatabaseValue]

  def apply[T <: DatabaseValue](key: String)(action: T => Unit): Unit = {
    values.get(key) match
      case Some(value: T) => action(value)
      case _ => throw new Exception("No value found for key: " + key)
  }
}
