package org.mo39.fmbh.datastructure.design

// TODO
class MovingAverage(size: Int) {

  var (sum, n, pre) = (0, 0, 0)

  def next(v: Int): Double = {
    if (n >= size) sum += v - pre
    else {
      sum += v
      n += 1
    }
    pre = v
    sum.toDouble / n
  }
}
