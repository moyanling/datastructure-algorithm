package org.mo39.fmbh.datastructure.string

object LongestUncommonSubsequenceI {

  sealed trait LongestUncommonSubsequenceI {
    def findLUSlength(a: String, b: String): Int
  }

  case object SOLUTION extends LongestUncommonSubsequenceI {
    override def findLUSlength(a: String, b: String): Int = {
      if (a == b) -1 else math.max(a.size, b.size)
    }
  }

}
