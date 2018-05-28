package org.mo39.fmbh.datastructure.linkedlist

import org.mo39.fmbh.commons.annotations.ProblemSource
import org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode
import org.mo39.fmbh.commons.classes.ListNode
import org.mo39.fmbh.commons.utils.Enumerable

/**
  * {{{
  * Merge two sorted linked lists and return it as a new list. The new list
  * should be made by splicing together the nodes of the first two lists.
  *
  * Example:
  *
  * Input: 1->2->4, 1->3->4
  * Output: 1->1->2->3->4->4
  * }}}
  *
  * @see [[https://leetcode.com/problems/merge-two-sorted-lists/ MergeTwoSortedLists]]
  * @author mo39.fmbh
  */
@ProblemSource(LeetCode)
sealed trait MergeTwoSortedLists {
  def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode
}

object MergeTwoSortedLists extends Enumerable[MergeTwoSortedLists] {

  /**
    * The case match can be shorten like Solution1 but this way looks clearer.
    */
  case object Solution0 extends MergeTwoSortedLists {
    override def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
      var (n1, n2)       = (l1, l2)
      var head: ListNode = null
      var cur: ListNode  = null
      while (n1 != null || n2 != null) {
        var newNode: ListNode = null
        (n1, n2) match {
          case (_, null) =>
            newNode = new ListNode(n1.x)
            n1 = n1.next
          case (null, _) =>
            newNode = new ListNode(n2.x)
            n2 = n2.next
          case _ =>
            newNode = new ListNode(math.min(n1.x, n2.x))
            if (n1.x < n2.x) n1 = n1.next else n2 = n2.next
        }
        if (head == null) { head = newNode; cur = head } else { cur.next = newNode; cur = cur.next }
      }
      head
    }
  }

  /**
    * In case where you are allowed to break the original linked list
    */
  case object Solution1 extends MergeTwoSortedLists {
    override def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode = {
      var head, cur, pre = null.asInstanceOf[ListNode]
      var (n1, n2)       = (l1, l2)
      while (n1 != null || n2 != null) {
        if (n1 == null || n1.x > n2.x) {
          cur = n2
          n2 = n2.next
        } else {
          cur = n1
          n1 = n1.next
        }
        if (head == null) head = cur
        if (pre != null) pre.next = cur
        pre = cur
      }
      head
    }
  }
  case object Solution2 extends MergeTwoSortedLists {
    override def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode =
      (l1, l2) match {
        case (_, null) => l1
        case (null, _) => l2
        case _ =>
          var newNode: ListNode = null
          if (l1.x > l2.x) {
            newNode = new ListNode(l2.x)
            newNode.next = mergeTwoLists(l1, l2.next)
          } else {
            newNode = new ListNode(l1.x)
            newNode.next = mergeTwoLists(l1.next, l2)
          }
          newNode
      }
  }

  /**
    * In case where you are allowed to break the original linked list
    */
  case object Solution3 extends MergeTwoSortedLists {
    override def mergeTwoLists(l1: ListNode, l2: ListNode): ListNode =
      (l1, l2) match {
        case (_, null) => l1
        case (null, _) => l2
        case _ =>
          if (l1.x > l2.x) {
            l2.next = mergeTwoLists(l1, l2.next)
            l2
          } else {
            l1.next = mergeTwoLists(l1.next, l2)
            l1
          }
      }
  }
}
