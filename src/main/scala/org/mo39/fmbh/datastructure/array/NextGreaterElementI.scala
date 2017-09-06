package org.mo39.fmbh.datastructure.array

object NextGreaterElementI {

  sealed trait NextGreaterElementI {
    def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int]
  }

  case object SOLUTION extends NextGreaterElementI {
    override def nextGreaterElement(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
      val map = nums2.zipWithIndex.toMap
      Array.tabulate(nums1.length) {
        i => nums2.zipWithIndex.find(p => p._1 > nums1(i) && p._2 > map(nums1(i))).orElse(Some((-1, 0))).get._1
      }
    }


  }

  def main(args: Array[String]): Unit = {
    SOLUTION.nextGreaterElement(Array(4, 1, 2), Array(1, 3, 4, 2))
  }

}
