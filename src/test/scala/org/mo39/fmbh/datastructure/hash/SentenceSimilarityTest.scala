package org.mo39.fmbh.datastructure.hash

import org.mo39.fmbh.commons.MoTestSuite

class SentenceSimilarityTest extends MoTestSuite[SentenceSimilarity] {

  g("basic") { solution =>
    assert(
      solution.areSentencesSimilar("great acting skills".split(" "),
                                   "fine drama talent".split(" "),
                                   Array(Array("great", "fine"), Array("acting", "drama"), Array("skills", "talent"))))
  }

  g("duplicate pair") { solution =>
    assert(
      solution.areSentencesSimilar("fine acting skills".split(" "),
                                   "fine acting talent".split(" "),
                                   Array(Array("skills", "talent"), Array("skills", "mo39"), Array("skills", "fmbh"))))
  }

}
