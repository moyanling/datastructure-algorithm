package org.mo39.fmbh.commons.classes;

public class ListNode {
  public int val;
  public ListNode next;
  /* For Scala ListNode definition */
  public int x;

  public ListNode(int x) {
    this.x = x;
    val = x;
  }

  public static ListNode of(String s) {
    String[] arr = s.split("->");
    if (arr.length == 0 || arr[0].equals("NULL")) return null;
    ListNode head = new ListNode(Integer.parseInt(arr[0]));
    ListNode cur = head;
    for (int i = 1; i < arr.length && !arr[i].equals("NULL"); i++) {
      cur.next = new ListNode(Integer.parseInt(arr[i]));
      cur = cur.next;
    }
    return head;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof ListNode)) return false;
    ListNode head1 = this;
    ListNode head2 = ((ListNode) obj);
    while (head1 != null && head2 != null) {
      if (head1.val != head2.val) return false;
      head1 = head1.next;
      head2 = head2.next;
    }
    return head1 == head2;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    for (ListNode head = this; head != null; head = head.next) {
      sb.append(head.val);
      sb.append("->");
    }
    return sb.append("NULL").toString();
  }
}
