package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.utils.Enumerable

sealed trait AddStrings {
  def addStrings(num1: String, num2: String): String
}

object AddStrings extends Enumerable[AddStrings] {

  /**
    * Take care of the type of variable. Char.toInt method returns the ASCII code.
    */
  case object Solution extends AddStrings {
    override def addStrings(num1: String, num2: String): String = {
      var (i, carry) = (0, 0)
      val result     = new StringBuilder
      val getDigit   = (s: String, i: Int) => if (i < s.length) s(s.length - 1 - i).asDigit else 0
      while (i < num1.length || i < num2.length || carry != 0) {
        val v = getDigit(num1, i) + getDigit(num2, i) + carry
        result.append(v % 10)
        carry = v / 10
        i += 1
      }
      result.reverse.toString
    }
  }

}
