package org.mo39.fmbh.algorithm.sort

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ArrayBuffer

/**
  * {{{
  * Suppose you have a random list of people standing in a queue. Each
  * person is described by a pair of integers (h, k), where h is the height
  * of the person and k is the number of people in front of this person who
  * have a height greater than or equal to h. Write an algorithm to
  * reconstruct the queue.
  *
  *
  * Note:
  * The number of people is less than 1,100.
  *
  *
  *
  *
  * Example
  *
  * Input:
  * [[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]
  *
  * Output:
  * [[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
  * }}}
  *
  * @see [[https://leetcode.com/problems/queue-reconstruction-by-height/ QueueReconstructionByHeight]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait QueueReconstructionByHeight {
  def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]]
}

object QueueReconstructionByHeight extends Enumerable[QueueReconstructionByHeight] {
  case object Solution extends QueueReconstructionByHeight {
    override def reconstructQueue(people: Array[Array[Int]]): Array[Array[Int]] = {
      var sorted = people.sortBy(_(1)).toList
      val result = ArrayBuffer[Array[Int]]()
      while (sorted.nonEmpty) {
        val p = sorted.head
        sorted = sorted.tail
        var count = 0
        val counts = result.map { i =>
          if (i(0) >= p(0)) count += 1
          count
        }
        val posi = counts.lastIndexWhere(_ <= p(1))
        result.insert(posi + 1, p)
      }
      result.toArray
    }
  }

}
