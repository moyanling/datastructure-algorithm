package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a binary matrix A, we want to flip the image horizontally, then
  * invert it, and return the resulting image.
  *
  * To flip an image horizontally means that each row of the image is
  * reversed.  For example, flipping [1, 1, 0] horizontally results in [0,
  * 1, 1].
  *
  * To invert an image means that each 0 is replaced by 1, and each 1 is
  * replaced by 0. For example, inverting [0, 1, 1] results in [1, 0, 0].
  *
  * Example 1:
  *
  *
  * Input: [[1,1,0],[1,0,1],[0,0,0]]
  * Output: [[1,0,0],[0,1,0],[1,1,1]]
  * Explanation: First reverse each row: [[0,1,1],[1,0,1],[0,0,0]].
  * Then, invert the image: [[1,0,0],[0,1,0],[1,1,1]]
  *
  *
  * Example 2:
  *
  *
  * Input: [[1,1,0,0],[1,0,0,1],[0,1,1,1],[1,0,1,0]]
  * Output: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
  * Explanation: First reverse each row:
  * [[0,0,1,1],[1,0,0,1],[1,1,1,0],[0,1,0,1]].
  * Then invert the image: [[1,1,0,0],[0,1,1,0],[0,0,0,1],[1,0,1,0]]
  *
  *
  * Notes:
  *
  *
  * 	1 <= A.length = A[0].length <= 20
  * 	0 <= A[i][j] <= 1
  * }}}
  *
  * @see [[https://leetcode.com/problems/flipping-an-image/ FlippingAnImage]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait FlippingAnImage {
  def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]]
}

object FlippingAnImage extends Enumerable[FlippingAnImage] {
  case object Solution extends FlippingAnImage {
    override def flipAndInvertImage(A: Array[Array[Int]]): Array[Array[Int]] = {
      val flipAndInvertRow = (arr: Array[Int]) => {
        val flip = (i: Int) => arr(i) = 1 - arr(i)
        for (i <- 0 until arr.length / 2) {
          if (arr(i) == arr(arr.length - 1 - i)) { flip(i); flip(arr.length - 1 - i) }
        }
        if (arr.length % 2 != 0) flip(arr.length / 2)
        arr
      }
      A.map(flipAndInvertRow)
    }
  }
}
