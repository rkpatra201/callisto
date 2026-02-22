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
class _21_Merge2SortedLinkedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode t1 = list1;
        ListNode t2 = list2;

        while(t1!=null && t2!=null){
            if(t1.val < t2.val){
                ListNode v = t1;
                t1 = t1.next;

                v.next = null;
                tail.next = v;
                tail = v;
             //   tail.next = null;
            }
            else if(t1.val > t2.val){
                ListNode v = t2;
                t2 = t2.next;
                
                v.next = null;
                tail.next = v;
                tail = v;
              //  tail.next = null;
            }
            else{
               ListNode v = t1;
                t1 = t1.next;

                v.next = null;
                tail.next = v;
                tail = v;
               // tail.next = null;

                v = t2;
                t2 = t2.next;
                
                v.next = null;
                tail.next = v;
                tail = v;
                //tail.next = null;
            }
        }

        // while(t1!=null){
        //       tail.next = t1;
        //         tail = t1;
        //         t1 = t1.next;
        //         tail.next = null;
        // }

        // while(t2!=null){
        //       tail.next = t2;
        //         tail = t2;
        //         t2 = t2.next;
        //         tail.next = null;
        // }

        if(t1!=null){
            tail.next = t1;
        }

        if(t2!=null){
            tail.next = t2;
        }

        return dummy.next;
    }
}