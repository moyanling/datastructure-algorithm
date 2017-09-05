package org.mo39.fmbh.datastructure.string

object DetectCapital {

  sealed trait DetectCapital {
    def detectCapitalUse(word: String): Boolean
  }

  case object SOLUTION_0 extends DetectCapital {
    override def detectCapitalUse(word: String): Boolean = {
      Array(word.toLowerCase.capitalize, word.toLowerCase, word.toUpperCase) contains word
    }
  }

  case object SOLUTION_1 extends DetectCapital {
    override def detectCapitalUse(word: String): Boolean = {
      word.matches("[A-Z]+|[a-z]+|[A-Z][a-z]+")
    }
  }

  case object SOLUTION_2 extends DetectCapital {
    override def detectCapitalUse(word: String): Boolean = {
      var count = 0
      for (c <- word) if (c.isUpper) count += 1
      count == word.size || count == 0 || count == 1 && word(0).isUpper
    }
  }

  def main(args: Array[String]): Unit = {
    SOLUTION_0.detectCapitalUse("USA")
    SOLUTION_1.detectCapitalUse("USA")
  }

}
