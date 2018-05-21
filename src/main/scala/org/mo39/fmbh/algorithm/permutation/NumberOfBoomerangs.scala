package org.mo39.fmbh.algorithm.permutation

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable

/**
  * {{{
  * Given n points in the plane that are all pairwise distinct, a
  * "boomerang" is a tuple of points (i, j, k) such that the distance
  * between i and j equals the distance between i and k (the order of the
  * tuple matters).
  *
  * Find the number of boomerangs. You may assume that n will be at most
  * 500 and coordinates of points are all in the range [-10000, 10000]
  * (inclusive).
  *
  * Example:
  *
  * Input:
  * [[0,0],[1,0],[2,0]]
  *
  * Output:
  * 2
  *
  * Explanation:
  * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
  * }}}
  *
  * @see [[https://leetcode.com/problems/number-of-boomerangs/ NumberOfBoomerangs]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait NumberOfBoomerangs {
  def numberOfBoomerangs(points: Array[Array[Int]]): Int
}

object NumberOfBoomerangs extends Enumerable[NumberOfBoomerangs] {
  case object Solution0 extends NumberOfBoomerangs {
    override def numberOfBoomerangs(points: Array[Array[Int]]): Int = {
      var sum = 0
      val distanceOf = (i: Int, j: Int) => {
        math.sqrt(
          math.pow(points(i)(0) - points(j)(0), 2) +
          math.pow(points(i)(1) - points(j)(1), 2)
        )
      }
      val map = points.indices
        .combinations(2)
        .map(arr => arr.toList -> distanceOf(arr(0), arr(1)))
        .toMap
      for (i <- points.indices) {
        val count = mutable.Map[Double, Int]()
        for (j <- points.indices if i != j) {
          val d = map(List(i, j).sorted)
          count.update(d, count.getOrElse(d, 0) + 1)
        }
        sum += count.values.map(i => i * (i - 1)).sum
      }
      sum
    }
  }
}
