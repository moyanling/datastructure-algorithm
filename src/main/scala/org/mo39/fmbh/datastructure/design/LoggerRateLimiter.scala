package org.mo39.fmbh.datastructure.design

// TODO
class LoggerRateLimiter() {

  val map = collection.mutable.Map[String, Int]()

  def shouldPrintMessage(timestamp: Int, message: String): Boolean = {
    if (map.contains(message) && timestamp - map(message) >= 10 || !map.contains(message)) {
      map.update(message, timestamp)
      return true
    }
    false
  }

}

object demo {

  def main(args: Array[String]): Unit = {
    var x = new LoggerRateLimiter
    println(x.shouldPrintMessage(1, "sda"))
    println(x.shouldPrintMessage(1, "sda1"))
    println(x.shouldPrintMessage(2, "sdadas"))
    println(x.shouldPrintMessage(4, "sda"))
    println(x.shouldPrintMessage(11, "sda"))
    println(x.shouldPrintMessage(12, "sda"))
  }
}