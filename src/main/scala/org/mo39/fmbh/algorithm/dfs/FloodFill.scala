package org.mo39.fmbh.algorithm.dfs

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable
import org.mo39.fmbh.commons.utils.Z._

/**
  * {{{
  *
  * An image is represented by a 2-D array of integers, each integer
  * representing the pixel value of the image (from 0 to 65535).
  *
  * Given a coordinate (sr, sc) representing the starting pixel (row and
  * column) of the flood fill, and a pixel value newColor, "flood fill" the
  * image.
  *
  * To perform a "flood fill", consider the starting pixel, plus any pixels
  * connected 4-directionally to the starting pixel of the same color as
  * the starting pixel, plus any pixels connected 4-directionally to those
  * pixels (also with the same color as the starting pixel), and so on.
  * Replace the color of all of the aforementioned pixels with the
  * newColor.
  *
  * At the end, return the modified image.
  *
  * Example 1:
  *
  * Input:
  * image = [[1,1,1],[1,1,0],[1,0,1]]
  * sr = 1, sc = 1, newColor = 2
  * Output: [[2,2,2],[2,2,0],[2,0,1]]
  * Explanation:
  * From the center of the image (with position (sr, sc) = (1, 1)), all
  * pixels connected
  * by a path of the same color as the starting pixel are colored with the
  * new color.
  * Note the bottom corner is not colored 2, because it is not
  * 4-directionally connected
  * to the starting pixel.
  *
  *
  *
  * Note:
  * The length of image and image[0] will be in the range [1, 50].
  * The given starting pixel will satisfy 0 <= sr < image.length and 0 <=
  * sc < image[0].length.
  * The value of each color in image[i][j] and newColor will be an integer
  * in [0, 65535].
  * }}}
  *
  * @see [[https://leetcode.com/problems/flood-fill/ FloodFill]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait FloodFill {
  def floodFill(image: Array[Array[Int]],
                sr: Int,
                sc: Int,
                newColor: Int): Array[Array[Int]]
}

object FloodFill extends Enumerable[FloodFill] {

  /**
    * This one marks the places that needs to be updated.
    * It has to set those places to a different value, e.g oldColor + 1
    * so that dfs won't visit back.
    */
  case object Solution0 extends FloodFill {
    override def floodFill(image: Array[Array[Int]],
                           sr: Int,
                           sc: Int,
                           newColor: Int): Array[Array[Int]] = {
      val oldColor = image(sr)(sc)
      val list = dfs(sr, sc, image, oldColor)
      list.foreach(t => image(t._1)(t._2) = newColor)
      image
    }
    def dfs(i: Int,
            j: Int,
            image: Array[Array[Int]],
            oldColor: Int): List[(Int, Int)] = {
      var result = List[(Int, Int)]()
      if (isValid(image, i, j) && image(i)(j) == oldColor) {
        image(i)(j) = oldColor + 1
        result = (i, j) :: result
        result = result ::: dfs(i + 1, j, image, oldColor)
        result = result ::: dfs(i - 1, j, image, oldColor)
        result = result ::: dfs(i, j + 1, image, oldColor)
        result = result ::: dfs(i, j - 1, image, oldColor)
      }
      result
    }
  }

  /**
    * If the oldColor is the same as the newColor, nothing needs to be done.
    */
  case object Solution1 extends FloodFill {
    override def floodFill(image: Array[Array[Int]],
                           sr: Int,
                           sc: Int,
                           newColor: Int): Array[Array[Int]] = {
      val oldColor = image(sr)(sc)
      if (oldColor == newColor) image
      else {
        dfs(sr, sc, image, oldColor, newColor)
        image
      }
    }
    def dfs(i: Int,
            j: Int,
            image: Array[Array[Int]],
            oldColor: Int,
            newColor: Int): Unit = {
      if (isValid(image, i, j) && image(i)(j) == oldColor) {
        image(i)(j) = newColor
        dfs(i + 1, j, image, oldColor, newColor)
        dfs(i - 1, j, image, oldColor, newColor)
        dfs(i, j + 1, image, oldColor, newColor)
        dfs(i, j - 1, image, oldColor, newColor)
      }
    }
  }

}
