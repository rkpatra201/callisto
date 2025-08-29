package org.dsa.examples.blind75._6ll;

// https://leetcode.com/problems/linked-list-cycle/submissions/1585938015/
public class _141DetectCycleInLinkedList {

  class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
      val = x;
      next = null;
    }
  }

  public boolean hasCycle(ListNode head) {
    ListNode p1 = head;
    ListNode p2 = head;

    ListNode curr = head;

    while (true) {


      if (p1 == null || p1.next == null) {
        break;
      }

      p2 = p2.next;
      p1 = p1.next.next;


      if (p1 == p2) {
        return true;
      }


      //   curr = curr.next;
    }

    return false;
  }

}
