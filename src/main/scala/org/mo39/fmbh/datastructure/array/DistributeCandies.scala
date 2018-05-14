package org.mo39.fmbh.datastructure.array

object DistributeCandies {

  sealed trait DistributeCandies {
    def distributeCandies(candies: Array[Int]): Int
  }

  case object SOLUTION extends DistributeCandies {
    override def distributeCandies(candies: Array[Int]): Int =
      math.min(candies.groupBy(identity).mapValues(_.length).size, candies.length / 2)
  }

}
