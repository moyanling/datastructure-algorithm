package org.mo39.fmbh.datastructure.hash

object JewelsAndStones {

  def numJewelsInStones(J: String, S: String): Int =
    S.count(J.toCharArray.contains)

  def main(args: Array[String]): Unit = {
    val J = "aA"
    val S = "aAAbbbb"
    println(numJewelsInStones(J, S))
  }

}
