package org.mo39.fmbh.datastructure.array

object ToeplitzMatrix {

  object Solution0 {
    def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
      (for {i <- matrix.indices; j <- matrix(i).indices} yield (i, j))
        .groupBy(t => t._1 - t._2)
        .map(_._2.map(index => matrix(index._1)(index._2)).toSet)
        .forall(_.size == 1)
    }

  }

  object Solution1 {
    def isToeplitzMatrix(matrix: Array[Array[Int]]): Boolean = {
      for (i <- 1 until matrix.length) {
        for (j <- 1 until matrix(i).length) {
          if (matrix(i)(j) != matrix(i - 1)(j - 1)) return false
        }
      }
      true
    }
  }

}
