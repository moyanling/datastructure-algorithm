package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.utils.S

object RemoveElement {

  sealed trait RemoveElement {
    def removeElement(nums: Array[Int], v: Int): Int
  }

  case object SOUTION extends RemoveElement {
    override def removeElement(nums: Array[Int], v: Int): Int = {
      S.partition(nums, _ != v)
    }
  }

}
