package org.mo39.fmbh.commons.utils

import org.mo39.fmbh.commons.utils.Z._

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
    val singleSolution = s"$prefix.Solution".toObject
    val list =
      if (singleSolution.isSuccess) List(singleSolution)
      else {
        Stream
          .from(0)
          .map(i => s"$prefix.Solution$i".toObject)
          .takeWhile(_.isSuccess)
          .toList
      }
    list.map(_.get.asInstanceOf[T])
  }

}
