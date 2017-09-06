package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.common.Z

object IslandPerimeter {

  sealed trait IslandPermieter {
    def islandPerimeter(grid: Array[Array[Int]]): Int
  }

  object SOLUTION extends IslandPermieter {

    override def islandPerimeter(grid: Array[Array[Int]]): Int = {
      var result = 0
      (0 until grid.length).foreach(i => {
        (0 until grid(i).length).foreach(j => {
          if (grid(i)(j) == 1) {
            result += 4
            if (Z.isValid(i - 1, j, grid) && grid(i - 1)(j) == 1) result -= 2
            if (Z.isValid(i, j - 1, grid) && grid(i)(j - 1) == 1) result -= 2
          }
        })
      })
      result
    }

  }

}
