/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(head.next!=null)
        {
            if(head.next.val==val)
            {
                head.next = head.next.next;
            }
            else{
                head = head.next;
            }
        }
        return dummy.next;
    }
}