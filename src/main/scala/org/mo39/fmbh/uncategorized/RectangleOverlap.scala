package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * A rectangle is represented as a list [x1, y1, x2, y2], where (x1, y1)
  * are the coordinates of its bottom-left corner, and (x2, y2) are the
  * coordinates of its top-right corner.
  *
  * Two rectangles overlap if the area of their intersection is positive. 
  * To be clear, two rectangles that only touch at the corner or edges do
  * not overlap.
  *
  * Given two (axis-aligned) rectangles, return whether they overlap.
  *
  * Example 1:
  *
  *
  * Input: rec1 = [0,0,2,2], rec2 = [1,1,3,3]
  * Output: true
  *
  *
  * Example 2:
  *
  *
  * Input: rec1 = [0,0,1,1], rec2 = [1,0,2,1]
  * Output: false
  *
  *
  * Notes:
  *
  *
  * 	Both rectangles rec1 and rec2 are lists of 4 integers.
  * 	All coordinates in rectangles will be between -10^9 and 10^9.
  * }}}
  *
  * @see [[https://leetcode.com/problems/rectangle-overlap/ RectangleOverlap]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait RectangleOverlap {
  def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean
}

object RectangleOverlap extends Enumerable[RectangleOverlap] {
  case object Solution extends RectangleOverlap {
    case class Point(x: Int, y: Int)
    override def isRectangleOverlap(rec1: Array[Int], rec2: Array[Int]): Boolean = {
      val d = (p: Point) => math.sqrt(p.x * p.x + p.y * p.y)
      val f = (rec: Array[Int]) => {
        val offset     = Point((rec1(0) + rec2(0)) / 2, (rec1(1) + rec2(1)) / 2)
        val bottomLeft = Point(rec1(0) - offset.x, rec1(1) - offset.y)
        val topRight   = Point(rec2(0) - offset.x, rec2(1) - offset.y)

      }

      ???
    }
  }
}
