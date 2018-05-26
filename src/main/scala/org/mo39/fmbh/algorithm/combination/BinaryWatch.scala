package org.mo39.fmbh.algorithm.combination

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * A binary watch has 4 LEDs on the top which represent the hours (0-11),
  * and the 6 LEDs on the bottom represent the minutes (0-59).
  * Each LED represents a zero or one, with the least significant bit on
  * the right.
  *
  * For example, the above binary watch reads "3:25".
  *
  * Given a non-negative integer n which represents the number of LEDs that
  * are currently on, return all possible times the watch could represent.
  *
  * Example:
  * Input: n = 1Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02",
  * "0:04", "0:08", "0:16", "0:32"]
  *
  *
  * Note:
  *
  * The order of output does not matter.
  * The hour must not contain a leading zero, for example "01:00" is not
  * valid, it should be "1:00".
  * The minute must be consist of two digits and may contain a leading
  * zero, for example "10:2" is not valid, it should be "10:02".
  * }}}
  *
  * @see [[https://leetcode.com/problems/binary-watch/ BinaryWatch]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait BinaryWatch {
  def readBinaryWatch(num: Int): List[String]
}

object BinaryWatch extends Enumerable[BinaryWatch] {

  /**
    * Note: [[scala.collection.SeqLike.combinations()]] returns an iterator.
    * It must be applied toList, otherwise iterator can only be visited once.
    */
  case object Solution extends BinaryWatch {
    override def readBinaryWatch(num: Int): List[String] = {
      val bits = List(1, 2, 4, 8, 16, 32)
      val combine = (to: Int, bound: Int) =>
        (0 to to).map(i => i -> bits.take(to).combinations(i).map(_.sum).withFilter(_ < bound).toList).toMap
      val hours   = combine(4, 12)
      val minutes = combine(6, 60).map(t => t._1 -> t._2.map(i => if (i < 10) s"0$i" else i.toString))
      (List(0, num - 6).max to List(num, 4).min).flatMap { i =>
        for (h <- hours(i); m <- minutes(num - i)) yield s"$h:$m"
      }.toList
    }
  }
}
