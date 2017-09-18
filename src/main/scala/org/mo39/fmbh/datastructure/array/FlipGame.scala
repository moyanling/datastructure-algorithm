package org.mo39.fmbh.datastructure.array

import scala.collection.mutable

object FlipGame {

  sealed trait FlipGame {
    def generatePossibleNextMoves(s: String): List[String]
  }

  case object SOLUTION extends FlipGame {
    override def generatePossibleNextMoves(s: String): List[String] = {
      val result = new mutable.ListBuffer[String]()
      (0 until s.length - 1).foreach(i => {
        if (s(i) == s(i + 1) && s(i) == '+') result += s.substring(0, i) + "--" + s.substring(i + 2, s.length)
      })
      result.toList
    }
  }

}
