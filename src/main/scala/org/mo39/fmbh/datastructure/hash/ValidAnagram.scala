package org.mo39.fmbh.datastructure.hash

object ValidAnagram {

  sealed trait ValidAnagram {
    def isAnagram(s: String, t: String): Boolean
  }

  case object SOLUTION extends ValidAnagram {
    override def isAnagram(s: String, t: String): Boolean = {
      val arr = new Array[Int](26)
      for (c <- s) arr(c - 'a') += 1
      for (c <- t) arr(c - 'a') -= 1
      arr.count(_ != 0) == 0
    }
  }

  def main(args: Array[String]): Unit = {
    println(SOLUTION.isAnagram("anagram", "nagaram"))
  }

}
