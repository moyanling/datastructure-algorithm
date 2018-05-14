package org.mo39.fmbh.datastructure.array

object MinimumMovesToEqualArrayElements {

  sealed trait MinimumMovesToEqualArrayElements {
    def minMoves(nums: Array[Int]): Int
  }

  case object SOLUTION extends MinimumMovesToEqualArrayElements {
    override def minMoves(nums: Array[Int]): Int =
      nums.map(_ - nums.min).sum
  }

}
