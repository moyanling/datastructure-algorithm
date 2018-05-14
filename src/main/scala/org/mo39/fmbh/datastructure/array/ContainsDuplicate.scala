package org.mo39.fmbh.datastructure.array

object ContainsDuplicate {

  sealed trait ContainsDuplicate {
    def containsDuplicate(nums: Array[Int]): Boolean
  }

  case object SOLUTION extends ContainsDuplicate {
    override def containsDuplicate(nums: Array[Int]): Boolean =
      nums.length != nums.distinct.size
  }

}
