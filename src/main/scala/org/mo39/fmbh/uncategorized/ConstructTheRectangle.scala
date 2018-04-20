package org.mo39.fmbh.uncategorized

import org.mo39.fmbh.commons.utils.Z

object ConstructTheRectangle {

  sealed trait ConstructTheRectangle {
    def constructRectangle(area: Int): Array[Int]
  }

  case object SOLUTION extends ConstructTheRectangle {
    override def constructRectangle(area: Int): Array[Int] = {
      var w = 1
      (1 to math.sqrt(area).toInt).foreach(i => if (area % i == 0) w = i)
      Array(area / w, w)
    }
  }

  def main(args: Array[String]): Unit = {
    Z.print(SOLUTION.constructRectangle(1))
  }

}
