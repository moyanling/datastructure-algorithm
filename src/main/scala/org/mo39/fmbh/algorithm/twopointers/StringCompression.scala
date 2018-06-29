package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given an array of characters, compress it in-place.
  *
  * The length after compression must always be smaller than or equal to
  * the original array.
  *
  * Every element of the array should be a character (not int) of length 1.
  *
  * After you are done modifying the input array in-place, return the new
  * length of the array.
  *
  *
  *
  * Follow up:
  * Could you solve it using only O(1) extra space?
  *
  *
  *
  *
  * Example 1:
  *
  * Input:
  * ["a","a","b","b","c","c","c"]
  *
  * Output:
  * Return 6, and the first 6 characters of the input array should be:
  * ["a","2","b","2","c","3"]
  *
  * Explanation:
  * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced
  * by "c3".
  *
  *
  *
  * Example 2:
  *
  * Input:
  * ["a"]
  *
  * Output:
  * Return 1, and the first 1 characters of the input array should be:
  * ["a"]
  *
  * Explanation:
  * Nothing is replaced.
  *
  *
  *
  * Example 3:
  *
  * Input:
  * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
  *
  * Output:
  * Return 4, and the first 4 characters of the input array should be:
  * ["a","b","1","2"].
  *
  * Explanation:
  * Since the character "a" does not repeat, it is not compressed.
  * "bbbbbbbbbbbb" is replaced by "b12".
  * Notice each digit has it's own entry in the array.
  *
  *
  *
  * Note:
  *
  * All characters have an ASCII value in [35, 126].
  * 1 <= len(chars) <= 1000.
  * }}}
  *
  * @see [[https://leetcode.com/problems/string-compression/ StringCompression]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait StringCompression {
  def compress(chars: Array[Char]): Int
}

object StringCompression extends Enumerable[StringCompression] {
  case object Solution extends StringCompression {
    override def compress(chars: Array[Char]): Int = {
      var (posi, j) = (-1, 0)
      for (i <- 1 to chars.length if i == chars.length || chars(i) != chars(j)) {
        val s = chars(j) + (if (i - j < 2) "" else (i - j).toString)
        for (c <- s) {
          posi += 1
          chars(posi) = c
        }
        j = i
      }
      posi + 1
    }
    def swap(chars: Array[Char], i: Int, j: Int): Unit = {
      if (i == j) return
      val tmp = chars(i)
      chars(i) = chars(j)
      chars(j) = tmp
    }
  }
}
