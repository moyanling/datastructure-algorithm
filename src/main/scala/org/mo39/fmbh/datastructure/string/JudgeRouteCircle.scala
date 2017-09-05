package org.mo39.fmbh.datastructure.string

object JudgeRouteCircle {

  def judgeCircle(moves: String): Boolean = {
    var (x, y) = (0, 0)
    for (c <- moves.toList) {
      c match {
        case 'L' => x += 1
        case 'R' => x -= 1
        case 'U' => y += 1
        case 'D' => y -= 1
      }
    }
    x == 0 && y == 0
  }

  def main(args: Array[String]): Unit = {
    println(judgeCircle("LLRRUD"))
  }
}