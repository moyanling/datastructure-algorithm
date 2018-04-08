package org.mo39.fmbh.algorithm.bitmanipulation

object NumberComplement {

  object SOLUTION_0 {
    def findComplement(num: Int): Int = {
      Integer.parseInt(num.toBinaryString.map(i => if (i == '1') '0' else '1'), 2)
    }
  }

  object SOLUTION_1 {
    def findComplement(num: Int): Int = {
      //TODO
      0
    }
  }

}
