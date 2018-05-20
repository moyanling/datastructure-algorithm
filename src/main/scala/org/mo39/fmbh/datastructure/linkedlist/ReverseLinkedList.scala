package org.mo39.fmbh.datastructure.linkedlist

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.ListNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Reverse a singly linked list.
  *
  * Example:
  *
  *
  * Input: 1->2->3->4->5->NULL
  * Output: 5->4->3->2->1->NULL
  *
  *
  * Follow up:
  *
  * A linked list can be reversed either iteratively or recursively. Could
  * you implement both?
  * }}}
  *
  * @see [[https://leetcode.com/problems/reverse-linked-list/ ReverseLinkedList]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait ReverseLinkedList {
  def reverseList(head: ListNode): ListNode
}

object ReverseLinkedList extends Enumerable[ReverseLinkedList] {

  case object Solution0 extends ReverseLinkedList {
    var head: ListNode = _
    override def reverseList(head: ListNode): ListNode = {
      recur(head, null)
      this.head
    }
    def recur(cur: ListNode, pre: ListNode): Unit =
      if (cur == null) this.head = pre
      else {
        recur(cur.next, cur)
        cur.next = pre
      }
  }

  /**
    * This one is way better than Solution0. It's more Scalatic and it gets rid of the instance variable.
    */
  case object Solution1 extends ReverseLinkedList {
    override def reverseList(head: ListNode): ListNode = {
      def recur(cur: ListNode, pre: ListNode): ListNode =
        cur match {
          case null => pre
          case _ =>
            val tmp = cur.next
            cur.next = pre
            recur(tmp, cur)
        }
      recur(head, null)
    }
  }

  case object Solution2 extends ReverseLinkedList {
    override def reverseList(head: ListNode): ListNode = {
      var (cur, pre) = (head, null.asInstanceOf[ListNode])
      while (cur != null) {
        val temp = cur.next
        cur.next = pre
        pre = cur
        cur = temp
      }
      pre
    }
  }

}
