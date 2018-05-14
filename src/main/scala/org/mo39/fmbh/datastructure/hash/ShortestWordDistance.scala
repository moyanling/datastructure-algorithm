package org.mo39.fmbh.datastructure.hash

object ShortestWordDistance {

  sealed trait ShortestWordDistance {
    def shortestDistance(words: Array[String], word1: String, word2: String): Int
  }

  case object SOLUTION extends ShortestWordDistance {
    override def shortestDistance(words: Array[String], word1: String, word2: String): Int = {
      var (posi, min) = (-1, words.length)
      for ((word, i) <- words.zipWithIndex) {
        if (word == word1 || word == word2) {
          if (posi != -1 && words(posi) != word) min = math.min(min, i - posi)
          posi = i
        }
      }
      min
    }
  }

  def main(args: Array[String]): Unit =
    SOLUTION.shortestDistance(Array("a", "b", "c", "d", "d"), "a", "d")

}
