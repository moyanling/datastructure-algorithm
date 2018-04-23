package org.mo39.fmbh.datastructure.array

import org.mo39.fmbh.commons.utils.Z

object IslandPerimeter {

  sealed trait IslandPermieter {
    def islandPerimeter(grid: Array[Array[Int]]): Int
  }

  object SOLUTION extends IslandPermieter {

    override def islandPerimeter(grid: Array[Array[Int]]): Int = {
      var result = 0
      grid.indices.foreach(i => {
        grid(i).indices.foreach(j => {
          if (grid(i)(j) == 1) {
            result += 4
            if (Z.isValid(grid, i - 1, j) && grid(i - 1)(j) == 1) result -= 2
            if (Z.isValid(grid, i, j - 1) && grid(i)(j - 1) == 1) result -= 2
          }
        })
      })
      result
    }

  }

}
