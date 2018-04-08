package org.mo39.fmbh.datastructure.stack

import scala.collection.mutable.ListBuffer

// It's quite interesting that using both Lists are faster than mutable (deprecated) Stack
object BaseballGame {

  object SOLUTION_0 {

    def calPoints(ops: Array[String]): Int = {
      var stack = List[Int]()
      for (op <- ops) {
        op match {
          case "C" => stack = stack.tail
          case "D" => stack = stack.head * 2 :: stack
          case "+" => stack = stack.take(2).sum :: stack
          case _ => stack = op.toInt :: stack
        }
      }
      stack.sum
    }

  }

  object SOLUTION_1 {

    def calPoints(ops: Array[String]): Int = {
      val stack = ListBuffer[Int]()
      for (op <- ops) {
        op match {
          case "C" => stack.remove(0)
          case "D" => stack.head * 2 +=: stack
          case "+" => stack.take(2).sum +=: stack
          case _ => op.toInt +=: stack
        }
      }
      stack.sum
    }

  }

  def main(args: Array[String]): Unit = {
    var list = ListBuffer(1, 2, 3)
    list.remove(0)
    println(list)
  }

}
