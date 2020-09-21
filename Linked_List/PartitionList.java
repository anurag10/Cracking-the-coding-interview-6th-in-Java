/*
Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
You should preserve the original relative order of the nodes in each of the two partitions.
*/

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
class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode firstLesser = new ListNode();
        ListNode firstGreater = new ListNode();
        ListNode prevGreater = firstGreater;
        ListNode prevLess = firstLesser;

        while(head != null)
        {
            ListNode next = head.next;
            head.next = null;
            if (head.val < x)
            {
                prevLess.next = head;
                prevLess = head;
            }
            else 
            {
                prevGreater.next = head;
                prevGreater = head;
            }

            head = next;
        }

        
        if (firstLesser.next != null)
        {
            prevLess.next = firstGreater.next;
            return firstLesser.next;
        }

        return firstGreater.next;
    }
}