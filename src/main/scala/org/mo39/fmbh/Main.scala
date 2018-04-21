package org.mo39.fmbh

import scala.collection.mutable.ArrayBuffer

object Main extends App {
  val buf = ArrayBuffer(1,2,3)
  val bldr = buf.mapResult(_.map(_ + 3))
  bldr.result().foreach(println)
}
