package org.mo39.fmbh.algorithm.twopointers

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * In a row of seats, 1 represents a person sitting in that seat, and 0
  * represents that the seat is empty. 
  *
  * There is at least one empty seat, and at least one person sitting.
  *
  * Alex wants to sit in the seat such that the distance between him and
  * the closest person to him is maximized. 
  *
  * Return that maximum distance to closest person.
  *
  *
  * Example 1:
  *
  *
  * Input: [1,0,0,0,1,0,1]
  * Output: 2
  * Explanation:
  * If Alex sits in the second open seat (seats[2]), then the closest
  * person has distance 2.
  * If Alex sits in any other open seat, the closest person has distance 1.
  * Thus, the maximum distance to the closest person is 2.
  *
  *
  * Example 2:
  *
  *
  * Input: [1,0,0,0]
  * Output: 3
  * Explanation:
  * If Alex sits in the last seat, the closest person is 3 seats away.
  * This is the maximum distance possible, so the answer is 3.
  *
  *
  * Note:
  *
  *
  * 	1 <= seats.length <= 20000
  * 	seats contains only 0s or 1s, at least one 0, and at least one 1.
  * }}}
  *
  * @see [[https://leetcode.com/problems/maximize-distance-to-closest-person/ MaximizeDistanceToClosestPerson]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MaximizeDistanceToClosestPerson {
  def maxDistToClosest(seats: Array[Int]): Int
}

object MaximizeDistanceToClosestPerson extends Enumerable[MaximizeDistanceToClosestPerson] {

  /**
    * When you wanna take the seat, you look left, then right, and find the position, right?
    */
  case object Solution0 extends MaximizeDistanceToClosestPerson {
    override def maxDistToClosest(seats: Array[Int]): Int = {
      var left = -1 // Points to the left of the empty seat where sits a person
      val leftView = seats.indices.map { i =>
        (left, seats(i)) match {
          case (-1, 0) => Int.MaxValue // No body sits left to the seat
          case (_, 1)  => left = i; 0
          case _       => i - left
        }
      }
      var right = -1
      val rightView = seats.indices.map { j =>
        val i = seats.length - j - 1
        (right, seats(i)) match {
          case (-1, 0) => Int.MaxValue // No body sits right to the seat
          case (_, 1)  => right = i; 0
          case _       => right - i
        }
      }.reverse
      seats.indices.map(i => math.min(leftView(i), rightView(i))).max
    }
  }

  /**
    * This one loop the array just once.
    * Basically it tries to find the place in the middle of two seated seats.
    * Loop through and find the MAX for every place.
    * And take care of the begin and end case.
    */
  case object Solution1 extends MaximizeDistanceToClosestPerson {
    override def maxDistToClosest(seats: Array[Int]): Int = {
      var max, pre = seats.indexWhere(_ == 1)
      for (i <- max + 1 until seats.length if seats(i) == 1) {
        max = math.max(max, (i - pre) / 2)
        pre = i
      }
      math.max(max, seats.length - 1 - pre)
    }
  }

}
