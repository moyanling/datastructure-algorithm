package org.mo39.fmbh.datastructure.linkedlist

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.ListNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Given a sorted linked list, delete all duplicates such that each
  * element appear only once.
  *
  * Example 1:
  *
  *
  * Input: 1->1->2
  * Output: 1->2
  *
  *
  * Example 2:
  *
  *
  * Input: 1->1->2->3->3
  * Output: 1->2->3
  * }}}
  *
  * @see [[https://leetcode.com/problems/remove-duplicates-from-sorted-list/ RemoveDuplicatesFromSortedList]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait RemoveDuplicatesFromSortedList {
  def deleteDuplicates(head: ListNode): ListNode
}

object RemoveDuplicatesFromSortedList extends Enumerable[RemoveDuplicatesFromSortedList] {
  case object Solution0 extends RemoveDuplicatesFromSortedList {
    override def deleteDuplicates(head: ListNode): ListNode = {
      var (cur, l) = (head, List[Int]())
      while (cur != null) {
        l = cur.x :: l
        cur = cur.next
      }
      var newHead = null.asInstanceOf[ListNode]
      for (v <- l.distinct) {
        val tmp = new ListNode(v)
        tmp.next = newHead
        newHead = tmp
      }
      newHead
    }
  }

  case object Solution1 extends RemoveDuplicatesFromSortedList {
    override def deleteDuplicates(head: ListNode): ListNode = {
      val headCopy = head
      var cur      = head
      while (cur != null) {
        if (cur.next != null && cur.next.x == cur.x) cur.next = cur.next.next
        else cur = cur.next
      }
      headCopy
    }
  }

}
