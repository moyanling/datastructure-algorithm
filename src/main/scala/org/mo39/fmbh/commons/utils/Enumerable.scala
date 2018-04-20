package org.mo39.fmbh.commons.utils

import scala.reflect.runtime.universe

trait Enumerable[T] {

  def solutions: List[T] = {
    val runtimeMirror = universe.runtimeMirror(getClass.getClassLoader)
    val prefix = this.getClass.getPackage.getName
    (0 to 2).map(i => {
      val module = runtimeMirror.staticModule(s"$prefix.Solution$i$$")
      runtimeMirror.reflectModule(module).instance.asInstanceOf[T]
    }).toList
  }

}
