package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable

/**
  * {{{
  * According to the Wikipedia's article: "The Game of Life, also known
  * simply as Life, is a cellular automaton devised by the British
  * mathematician John Horton Conway in 1970."
  *
  * Given a board with m by n cells, each cell has an initial state live
  * (1) or dead (0). Each cell interacts with its eight neighbors
  * (horizontal, vertical, diagonal) using the following four rules (taken
  * from the above Wikipedia article):
  *
  *
  * 	Any live cell with fewer than two live neighbors dies, as if caused by
  * under-population.
  * 	Any live cell with two or three live neighbors lives on to the next
  * generation.
  * 	Any live cell with more than three live neighbors dies, as if by
  * over-population..
  * 	Any dead cell with exactly three live neighbors becomes a live cell,
  * as if by reproduction.
  *
  *
  * Write a function to compute the next state (after one update) of the
  * board given its current state. The next state is created by applying
  * the above rules simultaneously to every cell in the current state,
  * where births and deaths occur simultaneously.
  *
  * Example:
  *
  *
  * Input:
  * [
  *   [0,1,0],
  *   [0,0,1],
  *   [1,1,1],
  *   [0,0,0]
  * ]
  * Output:
  * [
  *   [0,0,0],
  *   [1,0,1],
  *   [0,1,1],
  *   [0,1,0]
  * ]
  *
  *
  * Follow up:
  *
  *
  * 	Could you solve it in-place? Remember that the board needs to be
  * updated at the same time: You cannot update some cells first and then
  * use their updated values to update other cells.
  * 	In this question, we represent the board using a 2D array. In
  * principle, the board is infinite, which would cause problems when the
  * active area encroaches the border of the array. How would you address
  * these problems?
  * }}}
  *
  * @see [[https://leetcode.com/problems/game-of-life/ GameOfLife]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait GameOfLife {
  def gameOfLife(board: Array[Array[Int]]): Unit
}

object GameOfLife extends Enumerable[GameOfLife] {
  case object Solution0 extends GameOfLife {
    override def gameOfLife(b: Array[Array[Int]]): Unit = {
      val isValid = (i: Int, j: Int) => i >= 0 && j >= 0 && i < b.length && j < b(i).length
      val count = (i: Int, j: Int) =>
        List((i + 1, j),
             (i - 1, j),
             (i, j + 1),
             (i, j - 1),
             (i + 1, j + 1),
             (i + 1, j - 1),
             (i - 1, j + 1),
             (i - 1, j - 1)).count { case (x, y) => isValid(x, y) && b(x)(y) == 1 }
      var map = mutable.Map[(Int, Int), Int]()
      for (i <- b.indices; j <- b(i).indices) {
        count(i, j) match {
          case c if c < 2  => map += (i, j) -> 0
          case c if c == 2 => map += (i, j) -> b(i)(j)
          case c if c == 3 => map += (i, j) -> 1
          case c if c > 3  => map += (i, j) -> 0
        }
      }
      for ((i, j) <- map.keys) b(i)(j) = map((i, j))
    }
  }

  /**
    * in place != memory saving for this one.
    * In real case, the problem can be presented in two states using Boolean,
    * and therefore Solution1 won't work and Solution0 could save more spaces.
    */
  case object Solution1 extends GameOfLife {
    override def gameOfLife(b: Array[Array[Int]]): Unit = {
      val isValid = (i: Int, j: Int) => i >= 0 && j >= 0 && i < b.length && j < b(i).length
      val count = (i: Int, j: Int) =>
        List((i + 1, j),
             (i - 1, j),
             (i, j + 1),
             (i, j - 1),
             (i + 1, j + 1),
             (i + 1, j - 1),
             (i - 1, j + 1),
             (i - 1, j - 1)).count { case (x, y) => isValid(x, y) && math.abs(b(x)(y)) == 1 }
      for (i <- b.indices; j <- b(i).indices) {
        val c = count(i, j)
        if (b(i)(j) == 1 && (c < 2 || c > 3)) b(i)(j) = -1
        if (b(i)(j) == 0 && c == 3) b(i)(j) = -2
      }
      for (i <- b.indices; j <- b(i).indices) {
        if (b(i)(j) == -1) b(i)(j) = 0
        if (b(i)(j) == -2) b(i)(j) = 1
      }
    }
  }

}
