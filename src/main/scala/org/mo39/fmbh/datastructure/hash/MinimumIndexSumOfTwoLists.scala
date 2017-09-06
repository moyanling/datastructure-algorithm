package org.mo39.fmbh.datastructure.hash


object MinimumIndexSumOfTwoLists {

  sealed trait MinimIndexSumOfTwoLists {
    def findRestaurant(list1: Array[String], list2: Array[String]): Array[String]
  }

  case object SOLUTION extends MinimIndexSumOfTwoLists {
    override def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
      val (map1, map2) = (list1.zipWithIndex.toMap, list2.zipWithIndex.toMap)
      var min = Int.MaxValue
      val intersection = map1.keySet.intersect(map2.keySet)
      intersection.foreach(key => min = math.min(min, map1(key) + map2(key)))
      intersection.filter(key => map1(key) + map2(key) == min).toArray
    }
  }

  def main(args: Array[String]): Unit = {
    val list1 = Array("Shogun", "Tapioca Express", "Burger King", "KFC")
    val list2 = Array("KFC", "Shogun", "Burger King")
    SOLUTION.findRestaurant(list1, list2)
  }

}
