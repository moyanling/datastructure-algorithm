package org.mo39.fmbh.datastructure.array

//TODO lte
object ReverseWordsInAStringIii {

  sealed trait ReverseWordsInAStringIii {
    def reverseWords(s: String): String
  }

  case object SOLUTION extends ReverseWordsInAStringIii {
    override def reverseWords(s: String): String =
      s.split(' ').map(_.reverse).mkString(" ")
  }

  def main(args: Array[String]): Unit =
    println(SOLUTION.reverseWords("Let's take LeetCode contest"))

}
