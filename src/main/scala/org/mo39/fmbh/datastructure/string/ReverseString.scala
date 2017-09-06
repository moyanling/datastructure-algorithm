package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.common.Z._

import scala.language.implicitConversions

//TODO
object ReverseString extends Enumeration {

  protected case class Solution(reverseString: String => String) extends super.Val

  implicit def f(x: Value): Solution = x.asInstanceOf[Solution]

  val SOLUTION_0 = Solution(reverseString = s => s.reverse)

  val SOLUTION_1 = Solution(reverseString = s => {
    val arr = s.toCharArray
    for (i <- 0 until arr.length if i < arr.length / 2) swap(arr, i, arr.length - i - 1)
    String.valueOf(arr)
  })

  def main(args: Array[String]): Unit = {
    for (v <- ReverseString.values) println(v.reverseString("hello, world."))
  }
}