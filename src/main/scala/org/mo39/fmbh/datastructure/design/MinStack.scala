package org.mo39.fmbh.datastructure.design

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

import scala.collection.mutable.ArrayBuffer

/**
  * {{{
  * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
  *
  * push(x) -- Push element x onto stack.
  * pop() -- Removes the element on top of the stack.
  * top() -- Get the top element.
  * getMin() -- Retrieve the minimum element in the stack.
  * Example:
  * MinStack minStack = new MinStack();
  * minStack.push(-2);
  * minStack.push(0);
  * minStack.push(-3);
  * minStack.getMin();   --> Returns -3.
  * minStack.pop();
  * minStack.top();      --> Returns 0.
  * minStack.getMin();   --> Returns -2.
  * }}}
  *
  * @see [[https://leetcode.com/problems/min-stack/ MinStack]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MinStack {
  def push(x: Int)

  def pop()

  def top(): Int

  def getMin(): Int
}

object MinStack extends Enumerable[MinStack] {
  case object Solution extends MinStack {
    var list = List[(Int, Int)]()

    def push(x: Int) {
      (x, math.min(list.last._2, x)) :: list
    }

    def pop() {
      if (list.nonEmpty) list = list.tail
    }

    def top(): Int = if (list.isEmpty) null.asInstanceOf[Int] else list.head._1

    def getMin(): Int = if (list.isEmpty) null.asInstanceOf[Int] else list.head._2
  }
}
