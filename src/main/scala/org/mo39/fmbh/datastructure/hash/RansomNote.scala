package org.mo39.fmbh.datastructure.hash

object RansomNote {

  sealed trait RansomNote {
    def canConstruct(ransomNote: String, magazine: String): Boolean
  }

  case object SOLUTION extends RansomNote {
    override def canConstruct(ransomNote: String, magazine: String): Boolean = {
      if (magazine.size < ransomNote.size) return false
      val Array(map1, map2) = Array(ransomNote, magazine).map(_.toCharArray.groupBy(identity).mapValues(_.size))
      if (!(map1.keySet subsetOf map2.keySet)) return false
      map2.transform((k, v) => v - map1.getOrElse(k, 0)).filter(_._2 < 0).size <= 0
    }
  }

  def main(args: Array[String]): Unit = {
    val (ransomNote, magazine) = ("ada", "acab")
    println(SOLUTION.canConstruct(ransomNote, magazine))
  }

}
