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
        ListNode pre = dummy;
        while(head!=null)
        {
            if(head.val==val)
            {
                head = head.next;
                pre.next = head;
            }
            else{
                head = head.next;
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}