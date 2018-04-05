package org.mo39.fmbh.datastructure.hash


object MinimumIndexSumOfTwoLists {

  sealed trait MinimIndexSumOfTwoLists {
    def findRestaurant(list1: Array[String], list2: Array[String]): Array[String]
  }

  case object SOLUTION_0 extends MinimIndexSumOfTwoLists {
    override def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
      val (map1, map2) = (list1.zipWithIndex.toMap, list2.zipWithIndex.toMap)
      var min = Int.MaxValue
      val intersection = map1.keySet.intersect(map2.keySet)
      intersection.foreach(key => min = math.min(min, map1(key) + map2(key)))
      intersection.filter(key => map1(key) + map2(key) == min).toArray
    }
  }

  case object SOLUTION_1 extends MinimIndexSumOfTwoLists {
    override def findRestaurant(list1: Array[String], list2: Array[String]): Array[String] = {
      val (map1, map2) = (list1.zipWithIndex.toMap, list2.zipWithIndex.toMap)
      val s = map1.keySet.intersect(map2.keySet).map(k => k -> (map1(k) + map2(k))).toMap
      s.filter(p => p._2 == s.minBy(_._2)._2).keySet.toArray
    }
  }


  def main(args: Array[String]): Unit = {
    val list1 = Array("Shogun", "Tapioca Express", "Burger King", "KFC")
    val list2 = Array("KFC", "Shogun", "Burger King")
    SOLUTION_0.findRestaurant(list1, list2)
    SOLUTION_1.findRestaurant(list1, list2)
  }

}
