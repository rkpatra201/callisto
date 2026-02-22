package org.dsa.examples.blind75._6ll;

// https://leetcode.com/problems/remove-nth-node-from-end-of-list/submissions/1605138406/
public class _19RemoveNthFromLinkedList {
  public _141DetectCycleInLinkedList.ListNode removeNthFromEnd(_141DetectCycleInLinkedList.ListNode head, int n) {
    _141DetectCycleInLinkedList.ListNode first = head;
    _141DetectCycleInLinkedList.ListNode second = head;
    _141DetectCycleInLinkedList.ListNode prev = null;

    int i =1;
    while(i <= n && first!=null){ // move untill we reach n
      first = first.next;
      i++;
    }

    if(first == null){ // it means head delete
      return head.next;
    }

    while(first!=null){ // moving both and tracking prev of second
      first=first.next;
      prev = second;
      second = second.next;
    }

    prev.next = second.next;

    return head;
  }
}
