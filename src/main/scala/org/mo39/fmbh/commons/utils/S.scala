package org.mo39.fmbh.commons.utils

import org.mo39.fmbh.commons.utils.Z._

object S {

  def partition(nums: Array[Int], p: Int => Boolean): Int = {
    var j = 0
    nums.indices.foreach(i => {
      if (p(nums(i))) {
        swap(nums, i, j)
        j += 1
      }
    })
    j
  }


}