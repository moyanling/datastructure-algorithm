package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given two sentences words1, words2 (each represented as an array of strings),
  * and a list of similar word pairs pairs, determine if two sentences are similar.
  *
  * For example, "great acting skills" and "fine drama talent" are similar,
  * if the similar word pairs are
  * pairs = [["great", "fine"], ["acting","drama"], ["skills","talent"]].
  *
  * Note that the similarity relation is not transitive. For example,
  * if "great" and "fine" are similar, and "fine" and "good" are similar,
  * "great" and "good" are not necessarily similar.
  *
  * However, similarity is symmetric. For example, "great" and "fine"
  * being similar is the same as "fine" and "great" being similar.
  *
  * Also, a word is always similar with itself. For example, the sentences
  * words1 = ["great"], words2 = ["great"], pairs = [] are similar, even
  * though there are no specified similar word pairs.
  *
  * Finally, sentences can only be similar if they have the same number
  * of words. So a sentence like words1 = ["great"] can never be similar
  * to words2 = ["doubleplus","good"].
  *
  * Note:
  *
  * The length of words1 and words2 will not exceed 1000.
  * The length of pairs will not exceed 2000.
  * The length of each pairs[i] will be 2.
  * The length of each words[i] and pairs[i][j] will be in the range [1, 20].
  * }}}
  *
  * @see [[https://leetcode.com/problems/sentence-similarity/ SentenceSimilarity]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SentenceSimilarity {
  def areSentencesSimilar(words1: Array[String],
                          words2: Array[String],
                          pairs: Array[Array[String]]): Boolean
}

object SentenceSimilarity extends Enumerable[SentenceSimilarity] {
  case object Solution extends SentenceSimilarity {
    override def areSentencesSimilar(words1: Array[String],
                                     words2: Array[String],
                                     pairs: Array[Array[String]]): Boolean = {
      if (words1.length != words2.length) return false
      val m1 = pairs.groupBy(_(0)).map(g => g._1 -> g._2.map(_(1)).toSet)
      val m2 = pairs.groupBy(_(1)).map(g => g._1 -> g._2.map(_(0)).toSet)
      words1.indices.forall(i => {
        val (w1, w2) = (words1(i), words2(i))
        w1 == w2 ||
        (m1.contains(w1) && m1(w1).contains(w2)) ||
        (m2.contains(w1) && m2(w1).contains(w2))
      })
    }
  }
}
