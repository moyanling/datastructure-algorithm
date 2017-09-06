package org.mo39.fmbh.datastructure.array

object MinimumMovesToEqualArrayElements {

  sealed trait MinimumMovesToEqualArrayElements {
    def minMoves(nums: Array[Int]): Int
  }

  case object SOLUTION extends MinimumMovesToEqualArrayElements {
    override def minMoves(nums: Array[Int]): Int = ???
  }

  def main(args: Array[String]): Unit = {
    println(SOLUTION.minMoves(Array(1, 2147483647)))
  }

}
