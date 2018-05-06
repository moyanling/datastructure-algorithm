package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class LongestWordInDictionaryTest extends MoTestSuite[LongestWordInDictionary] {

  test("apple") { solution =>
    assert(solution.longestWord(
      Array("a", "banana", "app", "appl", "ap", "apply", "apple")) === "apple")
  }

  test("e") { solution =>
    assert(
      solution.longestWord(
        Array("ts",
              "e",
              "x",
              "pbhj",
              "opto",
              "xhigy",
              "erikz",
              "pbh",
              "opt",
              "erikzb",
              "eri",
              "erik",
              "xlye",
              "xhig",
              "optoj",
              "optoje",
              "xly",
              "pb",
              "xhi",
              "x",
              "o")) === "e")
  }

}
