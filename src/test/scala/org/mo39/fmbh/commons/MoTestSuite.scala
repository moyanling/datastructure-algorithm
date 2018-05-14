package org.mo39.fmbh.commons

import org.mo39.fmbh.commons.utils.Enumerable
import org.scalatest.FunSuite
import org.mo39.fmbh.commons.utils.Z._

/**
  * MoTestSuit.
  *
  * The naming convention of the sub class should be <name>Test if the class is testing <name> class.
  * And it should mix in the [[org.mo39.fmbh.commons.utils.Enumerable]] trait
  */
abstract class MoTestSuite[T] extends FunSuite {

  def g(testName: String = "")(testCase: T => Any): Unit = {
    /* Get the companion object of the trait T using some naming convention trick */
    val obj = getClass.getName.stripSuffix("Test").toObject[T]
    require(obj.isSuccess, getClass.getName.stripSuffix("Test"))
    /* Cast as Enumerable and get values */
    val solutions = obj.get.asInstanceOf[Enumerable[T]].values
    solutions.foreach(solution => {
      var name = solution.toString
      if (testName != "") name = s"${solution.toString}: $testName"
      /* Test each solution */
      super.test(name)(testCase(solution))
    })
  }

}
