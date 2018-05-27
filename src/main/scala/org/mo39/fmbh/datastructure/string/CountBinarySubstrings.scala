package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.annotations.{ ProblemSource, TLE }
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Give a string s, count the number of non-empty (contiguous) substrings
  * that have the same number of 0's and 1's, and all the 0's and all the
  * 1's in these substrings are grouped consecutively.
  *
  * Substrings that occur multiple times are counted the number of times
  * they occur.
  *
  * Example 1:
  *
  * Input: "00110011"
  * Output: 6
  * Explanation: There are 6 substrings that have equal number of
  * consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
  * Notice that some of these substrings repeat and are counted the number
  * of times they occur.
  * Also, "00110011" is not a valid substring because all the 0's (and 1's)
  * are not grouped together.
  *
  *
  *
  * Example 2:
  *
  * Input: "10101"
  * Output: 4
  * Explanation: There are 4 substrings: "10", "01", "10", "01" that have
  * equal number of consecutive 1's and 0's.
  *
  *
  *
  * Note:
  * s.length will be between 1 and 50,000.
  * s will only consist of "0" or "1" characters.
  * }}}
  *
  * @see [[https://leetcode.com/problems/count-binary-substrings/ CountBinarySubstrings]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
trait CountBinarySubstrings {
  def countBinarySubstrings(s: String): Int
}

object CountBinarySubstrings extends Enumerable[CountBinarySubstrings] {

  /* Iterate over length. Ugly and dumb. */
  @TLE
  case object Solution0 extends CountBinarySubstrings {
    override def countBinarySubstrings(s: String): Int = {
      var count    = 0
      val markDone = Array.fill(s.length)(false)
      for (len <- 2 to s.length by 2; i <- s.indices
           if i + len <= s.length && !markDone(i)) {
        val sub = s.substring(i, i + len)
        if (sub.count(_ == '1') == sub.count(_ == '0')
            && sub
              .substring(0, sub.length / 2)
              .to[Set]
              .size == 1) {
          count += 1
          markDone(i) = true
        }
      }
      count
    }
  }

  /* Takes the advantage of for loop with if */
  case object Solution1 extends CountBinarySubstrings {
    override def countBinarySubstrings(s: String): Int = {
      var count, i, len = 0
      for (j <- 1 until s.length if s(i) != s(j)) {
        if (len != 0) count += math.min(len, j - i)
        len = j - i
        i = j
      }
      count + math.min(s.length - i, len)
    }
  }

  /* Enhance the logic of Solution1 */
  case object Solution2 extends CountBinarySubstrings {
    override def countBinarySubstrings(s: String): Int = {
      var count, i, len = 0
      for (j <- 1 to s.length if j == s.length || s(i) != s(j)) {
        if (len != 0) count += math.min(len, j - i)
        len = j - i
        i = j
      }
      count
    }
  }

  case object Solution3 extends CountBinarySubstrings {
    override def countBinarySubstrings(s: String): Int = ???
  }

}
