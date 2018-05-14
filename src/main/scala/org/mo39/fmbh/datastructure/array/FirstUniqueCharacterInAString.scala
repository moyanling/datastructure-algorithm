package org.mo39.fmbh.datastructure.array

object FirstUniqueCharacterInAString {

  sealed trait FirstUniqueCharacterInAString {
    def firstUniqChar(s: String): Int
  }

  case object SOLUTION extends FirstUniqueCharacterInAString {
    override def firstUniqChar(s: String): Int = {
      val map = s.toArray.groupBy(identity).mapValues(_.size)
      s.toArray.zipWithIndex.find(i => map(i._1) == 1).getOrElse('0', -1)._2
    }
  }

  def main(args: Array[String]): Unit =
    println(SOLUTION.firstUniqChar("leetcode"))

}
