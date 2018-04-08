package org.mo39.fmbh.datastructure.queue

import scala.collection.mutable

class MovingAverageFromDataStream(_size: Int) {

  val q = new mutable.Queue[Int]()

  def next(`val`: Int): Double = {
    if (q.lengthCompare(_size) >= 0) q.dequeue
    q.enqueue(`val`)
    q.sum / q.length.toDouble
  }

}
