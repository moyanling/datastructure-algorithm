package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * We are given two strings, A and B.
  *
  * A shift on A consists of taking string A and moving the leftmost
  * character to the rightmost position. For example, if A = 'abcde', then
  * it will be 'bcdea' after one shift on A. Return True if and only if A
  * can become B after some number of shifts on A.
  *
  *
  * Example 1:
  * Input: A = 'abcde', B = 'cdeab'
  * Output: true
  *
  * Example 2:
  * Input: A = 'abcde', B = 'abced'
  * Output: false
  *
  *
  * Note:
  *
  *
  * 	A and B will have length at most 100.
  * }}}
  *
  * @see [[https://leetcode.com/problems/rotate-string/ RotateString]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait RotateString {
  def rotateString(A: String, B: String): Boolean
}

object RotateString extends Enumerable[RotateString] {
  case object Solution0 extends RotateString {
    override def rotateString(A: String, B: String): Boolean =
      A match {
        case B                         => true
        case _ if A.length != B.length => false
        case _ =>
          A.indices
            .map(_ + 1)
            .exists(i =>
              A.substring(0, i) == B.substring(B.length - i, B.length) &&
              A.substring(i, A.length) == B.substring(0, B.length - i))
      }
  }

  /**
    * Saves a few String concatenation but it requires to check empty String.
    */
  case object Solution1 extends RotateString {
    override def rotateString(A: String, B: String): Boolean =
      A match {
        case _ if A.length == 0        => B.length == 0
        case _ if A.length != B.length => false
        case _ =>
          A.indices
            .exists(i => B(i) == A(0) && B.substring(i, B.length) + B.substring(0, i) == A)
      }
  }
}
