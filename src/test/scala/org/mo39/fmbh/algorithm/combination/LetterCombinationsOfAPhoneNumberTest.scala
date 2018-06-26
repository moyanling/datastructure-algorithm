package org.mo39.fmbh.algorithm.combination

import org.mo39.fmbh.commons.MoTestSuite

class LetterCombinationsOfAPhoneNumberTest extends MoTestSuite[LetterCombinationsOfAPhoneNumber] {

  g() { solution =>
    assert(solution.letterCombinations("23") === List("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"))
  }

}
