package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ListBuffer

/**
  * {{{
  * In a string S of lowercase letters, these letters form consecutive
  * groups of the same character.
  *
  * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb",
  * "xxxx", "z" and "yy".
  *
  * Call a group large if it has 3 or more characters.  We would like the
  * starting and ending positions of every large group.
  *
  * The final answer should be in lexicographic order.
  *
  *  
  *
  * Example 1:
  *
  *
  * Input: "abbxxxxzzy"
  * Output: [[3,6]]
  * Explanation: "xxxx" is the single large group with starting  3 and
  * ending positions 6.
  *
  *
  * Example 2:
  *
  *
  * Input: "abc"
  * Output: []
  * Explanation: We have "a","b" and "c" but no large group.
  *
  *
  * Example 3:
  *
  *
  * Input: "abcdddeeeeaabbbcd"
  * Output: [[3,5],[6,9],[12,14]]
  *
  *  
  *
  * Note:  1 <= S.length <= 1000
  * }}}
  *
  * @see [[https://leetcode.com/problems/positions-of-large-groups/ PositionsOfLargeGroups]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PositionsOfLargeGroups {
  def largeGroupPositions(S: String): List[List[Int]]
}

object PositionsOfLargeGroups extends Enumerable[PositionsOfLargeGroups] {
  case object Solution extends PositionsOfLargeGroups {
    override def largeGroupPositions(S: String): List[List[Int]] = {
      val buf = ListBuffer[List[Int]]()
      var i   = 0
      for (j <- 0 to S.length if j == S.length || S(i) != S(j)) {
        if (j - i > 2) buf += List(i, j - 1)
        i = j
      }
      buf.toList
    }
  }
}
