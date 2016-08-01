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
        head = reverse(head);
        int count = 1;
        ListNode pre = new ListNode(0);
        pre.next = head;
        
        while(count<n)
        {
            pre = pre.next;
            count++;
        }
        pre.next = pre.next.next;
        return reverse(head)
    }
    public ListNode reverse(ListNode head)
    {
        ListNode pre = null;
        while(head!=null)
        {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}