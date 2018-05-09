package org.mo39.fmbh.commons.utils
import scala.reflect.runtime.universe._
import java.awt.Toolkit
import java.awt.datatransfer.StringSelection

import org.mo39.fmbh.commons.classes.TreeNode
import org.mo39.fmbh.datastructure.binarytree.SerializeAndDeserializeBinaryTree

import scala.language.implicitConversions
import scala.reflect.runtime.universe
import scala.util.Try

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

  /**
    * String Wrapper. Provide some convenient methods on String.
    *
    * @param str
    */
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
          /* Find the last space character before the width limit */
          val k = str.lastIndexWhere(_.isSpaceChar, j)
          if (k > i) {
            charArr(k) = '\n'
            i = k + 1
          }
        }
      }
      String.valueOf(charArr).split('\n')
    }

    lazy val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)

    /**
      * String to Object
      * The method tries to find the companion Object of generic type T.
      *
      * @tparam T the type of the class or trait of the companion Object
      */
    def toObject[T]: Try[T] = {
      Try {
        val module = runtimeMirror.staticModule(str)
        runtimeMirror.reflectModule(module).instance.asInstanceOf[T]
      }
    }

    /**
      * String to Instance
      * The methods uses deserialize method to make a new instance
      *
      * @tparam T the type of the expected instance
      */
    def as[T: TypeTag]: T = {
      val t = typeOf[T]
      t match {
        case _ if t == typeOf[TreeNode] =>
          SerializeAndDeserializeBinaryTree.Solution0
            .deserialize(str)
            .asInstanceOf[T]
        case _ => throw new UnsupportedOperationException
      }
    }

  }

}
