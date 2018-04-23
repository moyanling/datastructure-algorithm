package org.mo39.fmbh.commons.utils

import java.awt.Toolkit
import java.awt.datatransfer.StringSelection
import scala.language.implicitConversions
//import org.junit.Assert
//import org.mo39.fmbh.datastructure.binarytree.TreeNode
//import org.mo39.fmbh.datastructure.binarytree.TreeNode.LevelOrderSol
//import org.mo39.fmbh.datastructure.linkedlist.ListNode
//import com.google.common.base.Joiner

/**
  * Some uncategorized util collections
  */
object Z {

  // --------- Matrix Printers --------------
  def print[T](matrix: Array[Array[T]]): Unit = {
    println(matrix.map(_.mkString(", ")).mkString("\n"))
  }

  // ----------------------------------------
  // ------------ Swappers ------------------
  // ----------------------------------------
  /**
    * Helper function that swaps two elements at position i and j in an array.
    *
    * @param arr the array
    * @param i   position i
    * @param j   position j
    */
  def swap[T](arr: Array[T], i: Int, j: Int): Unit = {
    if (i == j) return
    val temp = arr(i)
    arr(i) = arr(j)
    arr(j) = temp
  }

  def swap(arr: Array[Int], i: Int, j: Int): Unit = {
    if (i == j) return
    arr(i) = arr(i) ^ arr(j) // now a is 6 and b is 4
    arr(j) = arr(i) ^ arr(j) // now a is 6 but b is 2 (original value of a)
    arr(i) = arr(i) ^ arr(j)
  }

  def isValid(arr: Array[Array[Int]], i: Int, j: Int): Boolean = {
    i >= 0 && j >= 0 && i < arr.length && j < arr(i).length
  }

  private val clipBoard = Toolkit.getDefaultToolkit.getSystemClipboard

  implicit val toStrWrapper: String => StrWrapper = StrWrapper

  case class StrWrapper(str: String) {

    /* Set the String to clipboard and return the String */
    def toClipboard: String = {
      val selection = new StringSelection(str)
      clipBoard.setContents(selection, selection)
      str
    }

    /**
      * Split the line to multiple lines to ensure the line does not exceed the width.
      *
      * Requires that the String only has one line.
      */
    def limitWidthTo(width: Int): Array[String] = {
      require(!str.contains("\n"))
      val charArr = str.toCharArray
      var i = 0
      for (j <- str.indices) {
        if (j - i > width) {
          // Find the last space character before the width limit
          val k = str.lastIndexWhere(_.isSpaceChar, j)
          if (k > i) {
            charArr(k) = '\n'
            i = k + 1
          }
        }
      }
      charArr.mkString.split('\n')
    }

  }

}
