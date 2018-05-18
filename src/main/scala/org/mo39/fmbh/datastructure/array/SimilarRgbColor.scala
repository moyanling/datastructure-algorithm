package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
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
    val arr = Array(0x00, 0x11, 0x22, 0x33, 0x44, 0x55, 0x66, 0x77, 0x88, 0x99, 0xaa, 0xbb, 0xcc, 0xdd, 0xee, 0xff)
    val closest = (s: String) => {
      require(s.length == 2)
      if (s.head == s.last) s.head.toString * 2
      else {
        val v = Integer.parseInt(s, 16)
        // No need to check boundary because v cannot be larger than 0xff
        val i   = arr.indices.find(i => arr(i) < v && arr(i + 1) > v).get
        val num = if (v - arr(i) > arr(i + 1) - v) i + 1 else i
        num.toHexString * 2
      }
    }: String
    override def similarRGB(color: String): String =
      "#" + color
        .substring(1)
        .grouped(2)
        .map(closest)
        .mkString
  }
}
