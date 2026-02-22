package org.dsa.examples.nc150.linkedlist;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class _206_ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
       if(head == null){
        return null;
       }
       if(head.next == null){
        return head;
       } 
       ListNode current = head;
       ListNode result = null;
       ListNode last = null;
       while(current!=null){
       
        ListNode next = current.next;

        ListNode visited = current; // mark current as visited
        visited.next =null; // break the link to avoid cycle
        visited.next = result; // point to the last visited node
        result = visited; // update result to the last visited node
        
        current = next;
       }
       return result;
    }
}