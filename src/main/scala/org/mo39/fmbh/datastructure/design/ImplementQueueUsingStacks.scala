package org.mo39.fmbh.datastructure.design

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Implement the following operations of a queue using stacks.
  *
  *
  * 	push(x) -- Push element x to the back of queue.
  * 	pop() -- Removes the element from in front of queue.
  * 	peek() -- Get the front element.
  * 	empty() -- Return whether the queue is empty.
  *
  *
  * Example:
  *
  *
  * MyQueue queue = new MyQueue();
  *
  * queue.push(1);
  * queue.push(2);
  * queue.peek();  // returns 1
  * queue.pop();   // returns 1
  * queue.empty(); // returns false
  *
  * Notes:
  *
  *
  * 	You must use only standard operations of a stack -- which means only
  * push to top, peek/pop from top, size, and is empty operations are
  * valid.
  * 	Depending on your language, stack may not be supported natively. You
  * may simulate a stack by using a list or deque (double-ended queue), as
  * long as you use only standard operations of a stack.
  * 	You may assume that all operations are valid (for example, no pop or
  * peek operations will be called on an empty queue).
  * }}}
  *
  * @see [[https://leetcode.com/problems/implement-queue-using-stacks/ ImplementQueueUsingStacks]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ImplementQueueUsingStacks {

  /** Push element x to the back of queue. */
  def push(x: Int)

  /** Removes the element from in front of queue and returns that element. */
  def pop(): Int

  /** Get the front element. */
  def peek(): Int

  /** Returns whether the queue is empty. */
  def empty(): Boolean
}

object ImplementQueueUsingStacks extends Enumerable[ImplementQueueUsingStacks] {
  case class Solution() extends ImplementQueueUsingStacks {
    var out = List[Int]()
    var in  = List[Int]()

    /** Push element x to the back of queue. */
    override def push(x: Int): Unit =
      if (out.isEmpty) out = x :: out
      else in = x :: in

    /** Removes the element from in front of queue and returns that element. */
    override def pop(): Int = {
      val result = out.head
      out = out.tail
      if (out.isEmpty)
        while (in.nonEmpty) {
          out = in.head :: out
          in = in.tail
        }
      result
    }

    /** Get the front element. */
    override def peek(): Int = out.head

    /** Returns whether the queue is empty. */
    override def empty(): Boolean = out.isEmpty && in.isEmpty
  }
}
