package org.mo39.fmbh.algorithm.dynamicprogramming

import org.mo39.fmbh.commons.MoTestSuite

class WordBreakTest extends MoTestSuite[WordBreak] {

  g("leetcode") { solution =>
    assert(solution.wordBreak("leetcode", List("leet", "code")) === true)
  }

  g("applepenapple") { solution =>
    assert(solution.wordBreak("catsandog", List("apple", "pen")) === false)
  }

  g("catsandog") { solution =>
    assert(solution.wordBreak("catsandog", List("cats", "dog", "sand", "and", "cat")) === false)
  }

  g("a") { solution =>
    assert(solution.wordBreak("a", List("a")) === true)
  }

}
