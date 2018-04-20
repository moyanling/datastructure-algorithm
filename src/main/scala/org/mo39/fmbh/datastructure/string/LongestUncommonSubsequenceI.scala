package org.mo39.fmbh.datastructure.string

object LongestUncommonSubsequenceI {

  sealed trait LongestUncommonSubsequenceI {
    def findLUSlength(a: String, b: String): Int
  }

  case object Solution extends LongestUncommonSubsequenceI {
    override def findLUSlength(a: String, b: String): Int = {
      if (a == b) -1 else math.max(a.length, b.length)
    }
  }

}
