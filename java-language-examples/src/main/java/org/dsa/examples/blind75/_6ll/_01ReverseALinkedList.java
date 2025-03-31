package org.dsa.examples.blind75.w2;

// https://leetcode.com/problems/reverse-linked-list/submissions/1585919938/
public class _01ReverseALinkedList {

  public static void main(String[] args) {
    ListNode node1 = new ListNode();
    node1.val = 1;

    ListNode node2 = new ListNode();
    node2.val = 2;

    ListNode node3 = new ListNode();
    node3.val = 3;

    node1.next = node2;
    node2.next = node3;

    ListNode result = new _01ReverseALinkedList().reverseList(node1);

    System.out.println(result);
  }

  private ListNode reverseRoot = null;

  public ListNode reverseList(ListNode head) {

    recursive(head);

    return reverseRoot;

  }

  private void recursive(ListNode head) {
    if (head == null) {
      return;
    }
    head = head.next;

    ListNode old = head;
  //  old.next = null;
    ListNode oldRoot = reverseRoot;
    reverseRoot = old;
    reverseRoot.next = oldRoot;

    recursive(head);
  }

  private static class ListNode {
    int val;
    ListNode next;
  }
}
