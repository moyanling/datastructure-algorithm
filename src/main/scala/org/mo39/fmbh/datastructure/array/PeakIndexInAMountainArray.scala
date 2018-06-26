package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Let's call an array A a mountain if the following properties hold:
  *
  *
  * 	A.length >= 3
  * 	There exists some 0 < i < A.length - 1 such that A[0] < A[1] < ...
  * A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1]
  *
  *
  * Given an array that is definitely a mountain, return any i such that
  * A[0] < A[1] < ... A[i-1] < A[i] > A[i+1] > ... > A[A.length - 1].
  *
  * Example 1:
  *
  *
  * Input: [0,1,0]
  * Output: 1
  *
  *
  *
  * Example 2:
  *
  *
  * Input: [0,2,1,0]
  * Output: 1
  *
  *
  * Note:
  *
  *
  * 	3 <= A.length <= 10000
  * 	0 <= A[i] <= 10^6
  * 	A is a mountain, as defined above.
  * }}}
  *
  * @see [[https://leetcode.com/problems/peak-index-in-a-mountain-array/ PeakIndexInAMountainArray]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait PeakIndexInAMountainArray {
  def peakIndexInMountainArray(A: Array[Int]): Int
}

object PeakIndexInAMountainArray extends Enumerable[PeakIndexInAMountainArray] {
  case object Solution extends PeakIndexInAMountainArray {
    override def peakIndexInMountainArray(A: Array[Int]): Int =
      (1 until A.length - 1).find(i => A(i - 1) < A(i) && A(i) > A(i + 1)).get
  }
}
