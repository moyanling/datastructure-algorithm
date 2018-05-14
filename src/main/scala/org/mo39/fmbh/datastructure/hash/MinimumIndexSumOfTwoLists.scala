package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  *
  * Suppose Andy and Doris want to choose a restaurant for dinner, and they
  * both have a list of favorite restaurants represented by strings.
  *
  *
  * You need to help them find out their common interest with the least
  * list index sum. If there is a choice tie between answers, output all of
  * them with no order requirement. You could assume there always exists an
  * answer.
  *
  *
  *
  * Example 1:
  *
  * Input:
  * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
  * ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse",
  * "Shogun"]
  * Output: ["Shogun"]
  * Explanation: The only restaurant they both like is "Shogun".
  *
  *
  *
  * Example 2:
  *
  * Input:
  * ["Shogun", "Tapioca Express", "Burger King", "KFC"]
  * ["KFC", "Shogun", "Burger King"]
  * Output: ["Shogun"]
  * Explanation: The restaurant they both like and have the least index sum
  * is "Shogun" with index sum 1 (0+1).
  *
  *
  *
  *
  * Note:
  *
  * The length of both lists will be in the range of [1, 1000].
  * The length of strings in both lists will be in the range of [1, 30].
  * The index is starting from 0 to the list length minus 1.
  * No duplicates in both lists.
  * }}}
  *
  * @see [[https://leetcode.com/problems/minimum-index-sum-of-two-lists/ MinimumIndexSumOfTwoLists]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MinimumIndexSumOfTwoLists {
  def findRestaurant(list1: Array[String], list2: Array[String]): Array[String]
}

object MinimumIndexSumOfTwoLists extends Enumerable[MinimumIndexSumOfTwoLists] {

  case object Solution0 extends MinimumIndexSumOfTwoLists {
    override def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
      val (map1, map2) = (list1.zipWithIndex.toMap, list2.zipWithIndex.toMap)
      var min          = Int.MaxValue
      val intersection = map1.keySet.intersect(map2.keySet)
      intersection.foreach(key => min = math.min(min, map1(key) + map2(key)))
      intersection.filter(key => map1(key) + map2(key) == min).toArray
    }
  }

  case object Solution1 extends MinimumIndexSumOfTwoLists {
    override def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
      val (map1, map2) = (list1.zipWithIndex.toMap, list2.zipWithIndex.toMap)
      val s            = map1.keySet.intersect(map2.keySet).map(k => k -> (map1(k) + map2(k))).toMap
      s.filter(p => p._2 == s.minBy(_._2)._2).keySet.toArray
    }
  }

}
