package org.mo39.fmbh.datastructure.hash


import org.mo39.fmbh.commons.utils.Z

import scala.collection.mutable.ArrayBuffer

object KeyboardRow extends Enumeration {

  protected case class Solution(findWords: Array[String] => Array[String]) extends super.Val

  implicit def f(x: Value): Solution = x.asInstanceOf[Solution]

  val map = Map('q' -> 1, 'w' -> 1, 'e' -> 1, 'r' -> 1, 't' -> 1, 'y' -> 1, 'u' -> 1, 'i' -> 1, 'o' -> 1, 'p' -> 1, 'a' -> 2, 's' -> 2, 'd' -> 2, 'f' -> 2, 'g' -> 2, 'h' -> 2, 'j' -> 2, 'k' -> 2, 'l' -> 2, 'z' -> 3, 'x' -> 3, 'c' -> 3, 'v' -> 3, 'b' -> 3, 'n' -> 3, 'm' -> 3)

  val SOLUTION = Solution(findWords = words => {
    var result = ArrayBuffer.empty[String]
    for (word <- words) {
      var (row, flag) = (map(word(0).toLower), true)
      word.foreach(c => flag &&= (map(c.toLower) == row))
      if (flag) result :+= word
    }
    result.toArray
  })

  def main(args: Array[String]): Unit = {
    for (v <- KeyboardRow.values) v.findWords(Array("Hello", "Alaska", "Dad", "Peace"))
  }

}
