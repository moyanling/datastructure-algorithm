package org.mo39.fmbh.commons.utils

import scala.reflect.runtime.universe
import scala.util.Try

/**
  * Makes the class enumerable as a type of trait T giving a naming convention as follows:
  *
  * 1. if there's only one implementation, the naming should be Solution
  * 2. If there's more than one implementaion, the names should be SolutionX, where X should start from 0
  */
trait Enumerable[T] {

  /**
    * Given the type of the trait, with some naming conventions,
    * return a list of solution instances that implements the trait using reflection.
    */
  def values: List[T] = {
    val s = this.getClass.getName
    val prefix = s.substring(0, s.length - 1)
    val singleSolution = forName(s"$prefix.Solution")
    if (singleSolution.isSuccess) return List(singleSolution.get)
    Stream
      .from(0)
      .map(i => forName(s"$prefix.Solution$i"))
      .takeWhile(_.isSuccess)
      .toList
      .map(_.get)
  }

  private def forName(fullName: String): Try[T] = {
    Try {
      val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
      val module = runtimeMirror.staticModule(fullName)
      runtimeMirror.reflectModule(module).instance.asInstanceOf[T]
    }
  }

}
