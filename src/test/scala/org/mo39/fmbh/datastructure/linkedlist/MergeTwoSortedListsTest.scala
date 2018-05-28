package org.mo39.fmbh.datastructure.linkedlist

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.ListNode

class MergeTwoSortedListsTest extends MoTestSuite[MergeTwoSortedLists] {
  g() { solution =>
    assert(solution.mergeTwoLists(ListNode.of("1->2->4"), ListNode.of("1->3->4")) === ListNode.of("1->1->2->3->4->4"))
  }
}
