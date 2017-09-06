package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.traits.NestedInteger


//TODO leetcode Compile Error
object NestedListWeightSum {

  def depthSum(nestedList: List[NestedInteger]): Int = {
    recur(nestedList, 1)
  }

  def recur(nestedList: List[NestedInteger], depth: Int): Int = {
    var sum = 0
    for (nested <- nestedList) sum += (if (nested.isInteger) depth * nested.getInteger else recur(nested.getList, depth + 1))
    return sum
  }

  def main(args: Array[String]): Unit = {

  }

}