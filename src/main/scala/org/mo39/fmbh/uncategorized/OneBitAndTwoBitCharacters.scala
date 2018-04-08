package org.mo39.fmbh.uncategorized

object OneBitAndTwoBitCharacters {

  def isOneBitCharacter(bits: Array[Int]): Boolean = {
    var i = 0
    while (i < bits.length - 1) if (bits(i) == 1) i += 2 else i += 1
    i == bits.length
  }

  def main(args: Array[String]): Unit = {
    val bits = Array(1, 0, 0, 0)
    println(isOneBitCharacter(bits))
  }

}
