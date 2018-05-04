package org.mo39.fmbh.datastructure.string

import org.mo39.fmbh.commons.MoTestSuite

class GoatLatinTest extends MoTestSuite[GoatLatin] {

  test() { solution =>
    assert(
      solution
        .toGoatLatin("The quick brown fox jumped over the lazy dog") === "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa")
  }

}
