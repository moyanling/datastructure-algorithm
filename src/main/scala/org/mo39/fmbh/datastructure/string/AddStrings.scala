package org.mo39.fmbh.datastructure.string

object AddStrings {

  sealed trait AddStrings {
    def addStrings(num1: String, num2: String): String
  }

  /**
   * Take care of the type of variable. Char.toInt method returns the ASCII code.
   */
  case object SOLUTION extends AddStrings {
    override def addStrings(num1: String, num2: String): String = {
      var (i, carry, result) = (0, 0, new StringBuilder)
      while (i < num1.length || i < num2.length || carry != 0) {
        val v = (if (i < num1.length) num1(num1.length - 1 - i) - '0' else 0) + (if (i < num2.length) num2(num2.length - 1 - i) - '0' else 0) + carry
        result.append(v % 10)
        carry = v / 10
        i += 1
      }
      result.reverse.toString
    }
  }

  def main(args: Array[String]): Unit = {
    println(SOLUTION.addStrings("10001", "6789"))
  }

}
