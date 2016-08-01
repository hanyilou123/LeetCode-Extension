/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i=0; i<n; i++)
        {
            head = head.next;
        }
        while(head!=null)
        {
            head = head.next;
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}