package org.mo39.fmbh.datastructure.linkedlist

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.ListNode

class ReverseLinkedListTest extends MoTestSuite[ReverseLinkedList] {

  def head1: Null = null
  def head2: ListNode = {
    val head = new ListNode(0)
    head.next = new ListNode(1)
    head.next.next = new ListNode(2)
    head
  }

  g("null") { solution =>
    assert(solution.reverseList(head1) === null)
  }

  g("0, 1, 2") { solution =>
    assert(solution.reverseList(head2) === ListNode.of("2->1->0->NULL"))
  }

}
