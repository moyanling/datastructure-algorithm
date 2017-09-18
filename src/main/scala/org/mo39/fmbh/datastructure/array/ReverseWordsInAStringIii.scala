package org.mo39.fmbh.datastructure.array

object ReverseWordsInAStringIii {

  sealed trait ReverseWordsInAStringIii {
    def reverseWords(s: String): String
  }

  case object SOLUTION extends ReverseWordsInAStringIii {
    override def reverseWords(s: String): String = {
      s.split(' ').transform(_.reverse).mkString(" ")
    }
  }

  def main(args: Array[String]): Unit = {
    SOLUTION.reverseWords("Let's take LeetCode contest")
  }

}
