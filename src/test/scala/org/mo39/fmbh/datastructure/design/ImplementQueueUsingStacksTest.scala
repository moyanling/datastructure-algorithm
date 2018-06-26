package org.mo39.fmbh.datastructure.design

import org.scalatest.FunSuite

class ImplementQueueUsingStacksTest extends FunSuite {

  test("Solution") {
    val solution = ImplementQueueUsingStacks.Solution()
    solution.push(1)
    solution.push(2)
    assert(solution.pop() === 1)
    println(solution.in, solution.out)
    assert(solution.peek() === 2)
  }

}
