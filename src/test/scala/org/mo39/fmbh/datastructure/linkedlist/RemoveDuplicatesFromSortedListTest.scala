package org.mo39.fmbh.datastructure.linkedlist

import org.mo39.fmbh.commons.MoTestSuite
import org.mo39.fmbh.commons.classes.ListNode

class RemoveDuplicatesFromSortedListTest extends MoTestSuite[RemoveDuplicatesFromSortedList] {

  g("null") { solution =>
    assert(solution.deleteDuplicates(null) === null)
  }

  g("1->1->2->3->3") { solution =>
    assert(solution.deleteDuplicates(ListNode.of("1->1->2->3->3")) === ListNode.of("1->2->3"))
  }

}
