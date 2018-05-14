package org.mo39.fmbh.datastructure.string

import scala.collection.mutable.ListBuffer

object FizzBuzz {

  sealed trait FizzBuzz {
    def fizzBuzz(n: Int): List[String]
  }

  object SOLUTION extends FizzBuzz {

    def fizzBuzz(n: Int): List[String] = {
      var result = ListBuffer.empty[String]
      (1 to n).foreach(i =>
        result += {
          i match {
            case _ if i % 3 == 0 && i % 5 == 0 => "FizzBuzz"
            case _ if i % 3 == 0 => "Fizz"
            case _ if i % 5 == 0 => "Buzz"
            case _ => i.toString
          }
      })
      result.toList
    }

  }

  def main(args: Array[String]): Unit =
    println(SOLUTION.fizzBuzz(15))

}
