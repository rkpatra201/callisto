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
class _25_ReverseNodesInGroupOfSize_K {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode current = head;
        ListNode reverse = null;
       // ListNode gHead = null;
        ListNode pGHead = null;
        while (current != null) {

            int count = 0;
            ListNode tHead = null;
            ListNode last = null;
            ListNode rem = current;
            while (current != null && count != k) {
                if (tHead == null) {
                    tHead = current;
                   // gHead = current;
                }
                last = current;
                count++;
                current = current.next;
                System.out.println("-----");
            }
            if (count != 0 && count < k) {
                pGHead.next = rem;
                break;
            }
          //  System.out.println("First Group");
            last.next = null;

            ListNode tGhead = tHead;

            if (reverse == null) {
                reverse = reverseList(tHead);
            } else {
                //    reverse = reverseList(tHead) ;
                pGHead.next = reverseList(tHead);
            }
            pGHead = tGhead;
          //  System.out.println(reverse.val + ":" + gHead.val);
        }

        return reverse;

    }

    public void show(ListNode head) {
        ListNode current = head;
        while (current != null) {
        //    System.out.println(current.val);
            current = current.next;

        }
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode current = head;
        ListNode result = null;
        ListNode last = null;
        while (current != null) {
            ListNode visited = current;
            ListNode next = current.next;

            visited.next = null;
            if (result == null) {
                result = visited;
            } else {
                visited.next = result;
                result = visited;
            }

            current = next;
        }
       // show(result);
        return result;
    }
}