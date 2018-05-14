package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a string S and a character C, return an array of integers
  * representing the shortest distance from the character C in the string.
  *
  * Example 1:
  *
  *
  * Input: S = "loveleetcode", C = 'e'
  * Output: [3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0]
  *
  *
  *  
  *
  * Note:
  *
  *
  * 	S string length is in [1, 10000].
  * 	C is a single character, and guaranteed to be in string S.
  * 	All letters in S and C are lowercase.
  * }}}
  *
  * @see [[https://leetcode.com/problems/shortest-distance-to-a-character/ ShortestDistanceToACharacter]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ShortestDistanceToACharacter {
  def shortestToChar(S: String, C: Char): Array[Int]
}

object ShortestDistanceToACharacter extends Enumerable[ShortestDistanceToACharacter] {
  case object Solution extends ShortestDistanceToACharacter {
    override def shortestToChar(S: String, C: Char): Array[Int] = {
      val seq = S.indices.filter(S(_) == C)
      S.indices
        .map(i => math.abs(seq.minBy(j => math.abs(j - i)) - i))
        .toArray
    }
  }
}
