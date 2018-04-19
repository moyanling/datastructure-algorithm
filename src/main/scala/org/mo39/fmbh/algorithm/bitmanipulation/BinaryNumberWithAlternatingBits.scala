package org.mo39.fmbh.algorithm.bitmanipulation

object BinaryNumberWithAlternatingBits {

  sealed trait BinaryNumberWithAlternatingBits {
    def hasAlternatingBits(n: Int): Boolean
  }

  object Solution0 extends BinaryNumberWithAlternatingBits {
    def hasAlternatingBits(n: Int): Boolean = n.toBinaryString.matches("^(10)*(1)?$")
  }

  object Solution1 {
    def hasAlternatingBits(n: Int): Boolean = {
      val num = (n >> 1) ^ n
      (num & (num + 1)) == 0
    }
  }

  object Solution2 {
    def hasAlternatingBits(n: Int): Boolean = {
      Set(0, 1, 2, 5, 10, 21, 42, 85, 170, 341, 682, 1365, 2730, 5461, 10922, 21845, 43690, 87381, 174762, 349525, 699050, 1398101, 2796202, 5592405, 11184810, 22369621, 44739242, 89478485, 178956970, 357913941, 715827882, 1431655765).apply(n)
    }
  }

}
