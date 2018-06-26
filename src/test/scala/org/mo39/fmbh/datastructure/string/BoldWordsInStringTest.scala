package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class BoldWordsInStringTest extends MoTestSuite[BoldWordsInString] {

  g("aabcd") { solution =>
    assert(solution.boldWords(Array("ab", "bc"), "aabcd") === "a<b>abc</b>d")
  }

  g("cebcecceab") { solution =>
    assert(
      solution.boldWords(Array("b", "dee", "a", "ee", "c"), "cebcecceab") === "<b>c</b>e<b>bc</b>e<b>cc</b>e<b>ab</b>")
  }

}
