package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.SourceValue.LeetCode


@ProblemSource(LeetCode)
sealed trait IpToCidr {

  def ipToCIDR(ip: String, n: Int): List[String]

}

case object Solution extends IpToCidr {
  override def ipToCIDR(ip: String, n: Int): List[String] = {
    List()
  }

  def main(args: Array[String]): Unit = {
    println('$' < '0')
  }
}