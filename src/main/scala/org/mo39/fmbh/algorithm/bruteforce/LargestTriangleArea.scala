package org.mo39.fmbh.algorithm.bruteforce

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * You have a list of points in the plane. Return the area of the largest
  * triangle that can be formed by any 3 of the points.
  *
  *
  * Example:
  * Input: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
  * Output: 2
  * Explanation:
  * The five points are show in the figure below. The red triangle is the
  * largest.
  *
  *
  *
  *
  * Notes:
  *
  *
  * 	3 <= points.length <= 50.
  * 	No points will be duplicated.
  * 	 -50 <= points[i][j] <= 50.
  * 	Answers within 10^-6 of the true value will be accepted as correct.
  *
  *
  *  
  * }}}
  *
  * @see [[https://leetcode.com/problems/largest-triangle-area/ LargestTriangleArea]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
trait LargestTriangleArea {
  def largestTriangleArea(points: Array[Array[Int]]): Double
}

object LargestTriangleArea extends Enumerable[LargestTriangleArea] {

  /* The key point of this solution is to filter Nan out */
  case object Solution extends LargestTriangleArea {
    override def largestTriangleArea(points: Array[Array[Int]]): Double = {
      val distance = (x: Array[Int], y: Array[Int]) => {
        math.sqrt(math.pow(x(0) - y(0), 2) + math.pow(x(1) - y(1), 2))
      }
      val heron = (a: Double, b: Double, c: Double) => {
        val s = (a + b + c) / 2.0
        math.sqrt(s * (s - a) * (s - b) * (s - c))
      }
      val map = points
        .combinations(2)
        .map(s => (s(0), s(1)) -> distance(s(0), s(1)))
        .toMap
      points
        .combinations(3)
        .map(index => {
          val a = map(index(0), index(1))
          val b = map(index(1), index(2))
          val c = map(index(0), index(2))
          heron(a, b, c)
        })
        .filterNot(_.isNaN)
        .max
    }
  }

}
