package org.mo39.fmbh.datastructure.hash

object SubdomainVisitCount {

  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    val arr = cpdomains.flatMap(pair => {
      var Array(count, domain) = pair.split(" ")
      (0 to domain.count(_ == '.')).map(i => {
        if (i != 0) domain = domain.replaceFirst(".*?\\.", "")
        domain -> count.toInt
      })
    })
    arr.groupBy(i => i._1).map(t => s"${t._2.map(_._2).sum} ${t._1}").toList
  }

}
