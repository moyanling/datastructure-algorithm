package org.mo39.fmbh.datastructure.linkedlist;

import org.mo39.fmbh.commons.annotations.ProblemSource;
import org.mo39.fmbh.commons.classes.ListNode;

import static org.mo39.fmbh.commons.annotations.ProblemSource.SourceValue.LeetCode;

/**
 * <pre>
 * {@code
 *
 * Write a function to delete a node (except the tail) in a singly linked
 * list, given only access to that node.
 *
 *
 *
 * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the
 * third node with value 3, the linked list should become 1 -> 2 -> 4
 * after calling your function.
 * }
 * </pre>
 *
 * @see <a href=https://leetcode.com/problems/delete-node-in-a-linked-list/>DeleteNodeInALinkedList</a>
 * @author mo39.fmbh
 */
@ProblemSource(LeetCode)
public enum DeleteNodeInALinkedList {

  SOLUTION {
    @Override
    public void deleteNode(ListNode node) {
      ListNode cur = node, next = node.next;
      cur.val = next.val;
      cur.next = next.next;
    }
  };

  public abstract void deleteNode(ListNode node);

}
