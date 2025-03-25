package org.dsa.examples.blind75.w2;

// https://leetcode.com/problems/reverse-linked-list/submissions/1585919938/
public class _01ReverseALinkedList {

  public ListNode reverseList(ListNode head) {

    if (head == null) {
      return null;
    }

    ListNode reverseRoot = null;

    ListNode curr = head;
    while (true) {
      if (curr == null) {
        break;
      }

      ListNode temp = curr;

      curr = curr.next;

      if(reverseRoot!=null){
        ListNode oldRoot = reverseRoot;
        reverseRoot = temp;
        reverseRoot.next = oldRoot;
        continue;
      }

      reverseRoot = temp;
      reverseRoot.next = null;
    }

    return reverseRoot;

  }
  private static class ListNode{
    int val;
    ListNode next;
  }
}
