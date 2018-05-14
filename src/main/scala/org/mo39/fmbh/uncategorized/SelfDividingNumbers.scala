package org.mo39.fmbh.uncategorized

object SelfDividingNumbers {

  def selfDividingNumbers(left: Int, right: Int): List[Int] =
    (left to right).filterNot(num => num.toString.exists(n => n != '0' || num % n.asDigit != 0)).toList

}
