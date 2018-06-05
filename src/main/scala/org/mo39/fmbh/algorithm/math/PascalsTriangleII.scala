package org.mo39.fmbh.algorithm.math

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a non-negative index k where k ≤ 33, return the kth index row of
  * the Pascal's triangle.
  *
  * Note that the row index starts from 0.
  *
  *
  * In Pascal's triangle, each number is the sum of the two numbers
  * directly above it.
  *
  * Example:
  *
  *
  * Input: 3
  * Output: [1,3,3,1]
  *
  *
  * Follow up:
  *
  * Could you optimize your algorithm to use only O(k) extra space?
  * }}}
  *
  * @see [[https://leetcode.com/problems/pascals-triangle-ii/ PascalsTriangleII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PascalsTriangleII {
  def getRow(rowIndex: Int): List[Int]
}

object PascalsTriangleII extends Enumerable[PascalsTriangleII] {

  /**
    * Well this is not bad. However Solution1 is better.
    */
  case object Solution0 extends PascalsTriangleII {
    override def getRow(rowIndex: Int): List[Int] = {
      var row = List(0, 1, 0)
      for (_ <- 1 to rowIndex) {
        row = 0 :: (1 until row.length).map(i => row(i - 1) + row(i)).toList ::: 0 :: Nil
      }
      row.filter(_ != 0)
    }
  }

  /**
    * Magic formula. Needs to take care of the Integer overflow due to the multiplication.
    * The tricky part is, the value should be of Long data type because the multiplication may over flow the Integer.
    */
  case object Solution1 extends PascalsTriangleII {
    override def getRow(rowIndex: Int): List[Int] = {
      (1 to rowIndex)
        .scanLeft(1L) { case (last, i) => last * (rowIndex - i + 1) / i }
        .map(_.toInt)
        .toList
    }
  }
}
