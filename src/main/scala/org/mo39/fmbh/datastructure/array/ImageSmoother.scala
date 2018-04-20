package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.utils.Z

object ImageSmoother {

  def imageSmoother(M: Array[Array[Int]]): Array[Array[Int]] = {
    if (M == null || M.length < 1) return null
    val result = Array.ofDim[Int](M.length, M(0).length)
    for (i <- 0 until M.length) {
      for (j <- 0 until M(i).length) {
        var (sum, cells) = (0, 0)
        for (p <- -1 to 1) {
          for (q <- -1 to 1) {
            if (Z.isValid(i + p, j + q, M)) {
              cells += 1
              sum += M(i + p)(j + q)
            }
          }
        }
        result(i)(j) = sum / cells
      }
    }
    result
  }

  def main(args: Array[String]): Unit = {
    val M: Array[Array[Int]] = Array(
      Array(1, 1, 1),
      Array(1, 0, 1),
      Array(1, 1, 1))
    for (i <- imageSmoother(M)) println(i.mkString(", "))
  }

}