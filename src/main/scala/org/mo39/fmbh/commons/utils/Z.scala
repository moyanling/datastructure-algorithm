package org.mo39.fmbh.commons.utils

import java.util
//import org.junit.Assert
//import org.mo39.fmbh.datastructure.binarytree.TreeNode
//import org.mo39.fmbh.datastructure.binarytree.TreeNode.LevelOrderSol
//import org.mo39.fmbh.datastructure.linkedlist.ListNode
//import com.google.common.base.Joiner


object Z {

  def isValid(i: Int, j: Int, M: Array[Array[Int]]): Boolean = {
    0 <= i && i < M.length && 0 <= j && j < M(i).length
  }

  // ----------------------------------------
  // ------------ Printers ------------------
  // ----------------------------------------

  def print(arr: Array[String]): Unit = {
    println(arr.mkString(","))
  }

  def print(arr: Array[Int]): Unit = {
    println(util.Arrays.toString(arr))
  }

  def print(arr: Array[Double]): Unit = {
    println(util.Arrays.toString(arr))
  }

  def print(arr: Array[Char]): Unit = {
    println(util.Arrays.toString(arr))
  }

  //  def print[T](head: Nothing): Unit = {
  //    while ( {
  //      head != null
  //    }) {
  //      printnb(head + " -> ")
  //      head = head.next
  //    }
  //    print("null")
  //  }

  //  def print(root: Nothing): Unit = {
  //    if (root == null) return
  //    root.bfs(LevelOrderSol.ITERATIVE_SOLUTION_WITH_NULL).stream.forEach((l) => print(Joiner.on(',').join(l.stream.map((o) => if (o == null) '#'
  //    else String.valueOf(o)).collect(Collectors.toList))))
  //  }

  // --------- Matrix Printers --------------
  def print(matrix: Array[Array[Int]]): Unit = {
    println("[")
    util.Arrays.stream(matrix).forEach((arr: Array[Int]) => println(" " + util.Arrays.toString(arr) + ","))
    println("]")
  }

  def print(matrix: Array[Array[Boolean]]): Unit = {
    println("[")
    util.Arrays.stream(matrix).forEach((arr: Array[Boolean]) => println(" " + util.Arrays.toString(arr) + ","))
    println("]")
  }

  def print(matrix: Array[Array[Double]]): Unit = {
    println("[")
    util.Arrays.stream(matrix).forEach((arr: Array[Double]) => println(" " + util.Arrays.toString(arr) + ","))
    println("]")
  }

  def print(matrix: Array[Array[Char]]): Unit = {
    println("[")
    util.Arrays.stream(matrix).forEach((arr: Array[Char]) => println(" " + util.Arrays.toString(arr) + ","))
    println("]")
  }

  def print(matrix: util.List[util.List[Integer]]): Unit = {
    println("[")
    matrix.stream.forEach((list: util.List[Integer]) => println(" " + list + ","))
    println("]")
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

  def swap(arr: Array[Char], i: Int, j: Int): Unit = {
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


  /**
    * Helper function that swaps two elements at position i and j in an ArrayList.
    *
    * @param list the list
    * @param i    position i
    * @param j    position j
    */
  def swap[T](list: util.List[T], i: Int, j: Int): Unit = {
    if (i == j) return
    list.set(j, list.set(i, list.get(j)))
  }

  def isValid(arr: Array[Array[Int]], i: Int, j: Int): Boolean = {
    i >= 0 && j >= 0 && i < arr.length && j < arr(i).length
  }

}
