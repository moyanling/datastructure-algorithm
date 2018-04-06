package org.mo39.fmbh.datastructure.hash

object FindAnagramMappings {

  def anagramMappings(A: Array[Int], B: Array[Int]): Array[Int] = {
    A.map(B.indexOf)
  }

}
