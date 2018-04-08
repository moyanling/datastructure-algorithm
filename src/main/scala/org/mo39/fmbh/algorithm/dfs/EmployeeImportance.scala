package org.mo39.fmbh.algorithm.dfs

import org.mo39.fmbh.commons.classes.Employee

object EmployeeImportance {

  def getImportance(employees: Seq[Employee], id: Int): Int = {
    val map = employees.map(e => e.id -> e).toMap
    dfs(map, Seq(map(id)))
  }

  def dfs(map: Map[Int, Employee], seq: Seq[Employee]): Int = {
    seq.foldLeft(0)(_ + _.importance) + dfs(map, seq.map(e => map(e.id)))
  }

}