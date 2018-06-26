package org.mo39.fmbh.commons

import org.mo39.fmbh.commons.utils.Enumerable
import org.scalatest.FunSuite
import org.mo39.fmbh.commons.utils.Z._

/**
  * MoTestSuit.
  *
  * The naming convention of the sub class should be <name>Test if the class is testing <name> class.
  * It is required to be in the same package and
  * it should mix in the [[org.mo39.fmbh.commons.utils.Enumerable]] trait
  */
abstract class MoTestSuite[T] extends FunSuite {

  def g(testName: Any = "")(testCase: T => Any): Unit = {
    /* Get the companion object of the trait T using some naming convention trick */
    val obj = getClass.getName.stripSuffix("Test").toObject[T]
    require(obj.isSuccess, getClass.getName.stripSuffix("Test"))
    /* Cast as Enumerable and get values */
    val solutions = obj.get.asInstanceOf[Enumerable[T]].values
    /* Test each solution */
    solutions.foreach(solution => {
      var name = solution.toString
      if (testName.toString != "") name = s"${solution.toString}: $testName"
      try {
        testCase(solution)
        super.test(name)( /* Pass */ )
      } catch {
        case _: NotImplementedError => // Skip those not implemented
        case e: Exception           => super.test(name)(throw e)
      }
    })
  }

}
