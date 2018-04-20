package org.mo39.fmbh.datastructure.string

sealed trait IpToCidr {

  def ipToCIDR(ip: String, n: Int): List[String]

}

case object Solution extends IpToCidr {
  override def ipToCIDR(ip: String, n: Int): List[String] = {
    List()
  }
}