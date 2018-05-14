package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class MinimumIndexSumOfTwoListsTest extends MoTestSuite[MinimumIndexSumOfTwoLists] {

  val list1 = Array("Shogun", "Tapioca Express", "Burger King", "KFC")
  val list2 = Array("KFC", "Shogun", "Burger King")

  g("common item with least index should be Shogun") { solution =>
    assert(solution.findRestaurant(list1, list2) === Array("Shogun"))
  }

}
