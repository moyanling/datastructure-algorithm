package org.mo39.fmbh.datastructure.hash

object PalindromePermutation {

  sealed trait PalindromePermutation {
    def canPermutePalindrome(s: String): Boolean
  }

  case object SOLUTION extends PalindromePermutation {
    override def canPermutePalindrome(s: String): Boolean = {
      if (s.groupBy(identity).mapValues(_.length).count(_._2 % 2 == 1) > 1) true else false
    }
  }

  def main(args: Array[String]): Unit = {
    println(SOLUTION.canPermutePalindrome("aab"))
  }

}
