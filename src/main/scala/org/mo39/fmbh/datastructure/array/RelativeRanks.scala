package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.utils.Z

object RelativeRanks {

  sealed trait RelativeRanks {
    def findRelativeRanks(nums: Array[Int]): Array[String]
  }

  case object SOLUTION extends RelativeRanks {
    override def findRelativeRanks(nums: Array[Int]): Array[String] = {
      val map = nums.sortWith((i1, i2) => i1 > i2).zipWithIndex.toMap
      nums.map(i => {
        map(i) match {
          case 0 => "Gold Medal"
          case 1 => "Silver Medal"
          case 2 => "Bronze Medal"
          case _ => (map(i) + 1).toString
        }
      })
    }
  }

  def main(args: Array[String]): Unit = {
     SOLUTION.findRelativeRanks(Array(10,3,8,9,4))
  }

}
