package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a column title as appear in an Excel sheet, return its
  * corresponding column number.
  *
  * For example:
  *
  *
  *     A -> 1
  *     B -> 2
  *     C -> 3
  *     ...
  *     Z -> 26
  *     AA -> 27
  *     AB -> 28
  *     ...
  *
  *
  * Example 1:
  *
  *
  * Input: "A"
  * Output: 1
  *
  *
  * Example 2:
  *
  *
  * Input: "AB"
  * Output: 28
  *
  *
  * Example 3:
  *
  *
  * Input: "ZY"
  * Output: 701
  * }}}
  *
  * @see [[https://leetcode.com/problems/excel-sheet-column-number/ ExcelSheetColumnNumber]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ExcelSheetColumnNumber {
  def titleToNumber(s: String): Int
}

object ExcelSheetColumnNumber extends Enumerable[ExcelSheetColumnNumber] {
  case object Solution0 extends ExcelSheetColumnNumber {
    override def titleToNumber(s: String): Int =
      s.indices
        .map(i => math.pow(26, s.length - i - 1).toInt * (s(i) - '@'))
        .sum
  }

  /* This one brings a different perspective with a clean code */
  case object Solution1 extends ExcelSheetColumnNumber {
    override def titleToNumber(s: String): Int = ???
  }
}
