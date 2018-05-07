package org.mo39.fmbh.algorithm.math

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * In the following, every capital letter represents some hexadecimal
  * digit from 0 to f.
  *
  * The red-green-blue color "#AABBCC" can be written as "#ABC"
  * in shorthand.  For example, "#15c" is shorthand for the color
  * "#1155cc".
  *
  * Now, say the similarity between two colors "#ABCDEF" and
  * "#UVWXYZ" is -(AB - UV)^2 - (CD - WX)^2 - (EF - YZ)^2.
  *
  * Given the color "#ABCDEF", return a 7 character color that
  * is most similar to #ABCDEF, and has a shorthand (that is,
  * it can be represented as some "#XYZ"
  *
  * Example 1:
  * Input: color = "#09f166"
  * Output: "#11ee66"
  * Explanation:
  * The similarity is -(0x09 - 0x11)^2 -(0xf1 - 0xee)^2 - (0x66 - 0x66)^2 = -64 -9 -0 = -73.
  * This is the highest among any shorthand color.
  * Note:
  *
  * color is a string of length 7.
  * color is a valid RGB color: for i > 0, color[i] is a
  * hexadecimal digit from 0 to f
  * Any answer which has the same (highest) similarity as
  * the best answer will be accepted.
  * All inputs and outputs should use lowercase letters,
  * and the output is 7 characters.
  * }}}
  *
  * @see [[https://leetcode.com/problems/similar-rgb-color/ SimilarRgbColor]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait SimilarRgbColor {
  def similarRGB(color: String): String
}

object SimilarRgbColor extends Enumerable[SimilarRgbColor] {
  case object Solution extends SimilarRgbColor {
    val min = (seq: Seq[Int]) => {
      require(seq.length == 2)
      if (seq.head == seq.last) seq.head
      else {
        val Seq(a, b) = seq.sorted
        val product = a * b
        val k = Stream.from(b, -1).takeWhile(i => i * i > product).last
        println(product - (k - 1) * (k - 1))
        if ((k * k - product) > (product - (k - 1) * (k - 1))) k - 1 else k
      }
    }
    override def similarRGB(color: String): String = {
      "#" + color
        .substring(1)
        .map(_.asDigit)
        .grouped(2)
        .map(min(_).toHexString * 2).mkString
    }
  }
}
