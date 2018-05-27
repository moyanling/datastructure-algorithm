package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ArrayBuffer

/**
  * {{{
  *
  * Given two arrays, write a function to compute their intersection.
  *
  *
  * Example:
  * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].
  *
  *
  * Note:
  *
  * Each element in the result should appear as many times as it shows in
  * both arrays.
  * The result can be in any order.
  *
  *
  *
  * Follow up:
  *
  * What if the given array is already sorted? How would you optimize your
  * algorithm?
  * What if nums1's size is small compared to nums2's size? Which algorithm
  * is better?
  * What if elements of nums2 are stored on disk, and the memory is limited
  * such that you cannot load all elements into the memory at once?
  * }}}
  *
  * @see [[https://leetcode.com/problems/intersection-of-two-arrays-ii/ IntersectionOfTwoArraysII]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait IntersectionOfTwoArraysII {
  def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int]
}

object IntersectionOfTwoArraysII extends Enumerable[IntersectionOfTwoArraysII] {

  /**
    * It is required to call {{{keys.toList}}} otherwise the duplicate will be removed since {{{keys}}} is a Set.
    */
  case object Solution0 extends IntersectionOfTwoArraysII {
    override def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
      val count        = (arr: Array[Int]) => arr.groupBy(identity).mapValues(_.length)
      val (map1, map2) = (count(nums1), count(nums2))
      val keys         = map1.keySet.intersect(map2.keySet)
      keys.toList.flatMap(key => List.fill(math.min(map1(key), map2(key)))(key)).toArray
    }
  }

  case object Solution1 extends IntersectionOfTwoArraysII {
    override def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = nums1.intersect(nums2)
  }

  /**
    * Follow up: If the array is already sorted
    */
  case object Solution2 extends IntersectionOfTwoArraysII {
    override def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
      val (n1, n2) = (nums1.sorted, nums2.sorted)
      var i, j     = 0
      var buf      = ArrayBuffer[Int]()
      while (i < n1.length && j < n2.length) {
        if (n1(i) < n2(j)) i += 1
        else if (n1(i) > n2(j)) j += 1
        else {
          buf += n1(i)
          i += 1; j += 1
        }
      }
      buf.toArray
    }
  }

  /**
    * Follow up: if nums1.length << nums2.length or nums2 on the disk
    */
  case object Solution3 extends IntersectionOfTwoArraysII {
    override def intersect(nums1: Array[Int], nums2: Array[Int]): Array[Int] = {
      var buf    = ArrayBuffer[Int]()
      var counts = nums1.groupBy(identity).mapValues(_.length)
      for (i <- nums2 if counts.contains(i)) {
        buf += i
        val count = counts(i)
        if (count < 2) counts -= i
        else counts = counts.updated(i, count - 1)
        if (counts.isEmpty) return buf.toArray
      }
      buf.toArray
    }
  }

}
