package org.mo39.fmbh.datastructure.hash

object FindTheDifference {

  sealed trait FindTheDifference {
    def findTheDifference(s: String, t: String): Char
  }

  object SOLUTION extends FindTheDifference {

    override def findTheDifference(s: String, t: String): Char = {
      val arr = Array.fill(26) { 0 }
      for (c <- t) arr(c - 'a') += 1
      for (c <- s) arr(c - 'a') -= 1
      (0 to 25).foreach(i => if (arr(i) > 0) return (i + 'a').toChar)
      'a'
    }

  }

  def main(args: Array[String]): Unit =
    println(SOLUTION.findTheDifference("abc", "abcd"))

}
