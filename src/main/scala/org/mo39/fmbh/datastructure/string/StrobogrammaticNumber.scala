package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
  *
  * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
  *
  * Example 1:
  *
  * Input:  "69"
  * Output: true
  * Example 2:
  *
  * Input:  "88"
  * Output: true
  * Example 3:
  *
  * Input:  "962"
  * Output: false
  * }}}
  *
  * @see [[https://leetcode.com/problems/strobogrammatic-number/ StrobogrammaticNumber]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait StrobogrammaticNumber {
  def isStrobogrammatic(num: String): Boolean
}

object StrobogrammaticNumber extends Enumerable[StrobogrammaticNumber] {
  case object Solution extends StrobogrammaticNumber {
    override def isStrobogrammatic(num: String): Boolean = {
      val map               = Map('0' -> '0', '1' -> '1', '6' -> '9', '8' -> '8', '9' -> '6')
      val isStrobogrammatic = (i: Int) => map.getOrElse(num(i), -1) == num(num.length - 1 - i)
      (0 until num.length / 2).forall(isStrobogrammatic) && isStrobogrammatic(num.length / 2)
    }
  }
}
