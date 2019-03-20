/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(0);
        ListNode large = new ListNode(0);
        ListNode k = small;
        ListNode y = large;
        
        while(head!=null)
        {
            if(head.val < x)
            {
                k.next = head;
                k = k.next;
            }
            else
            {
                y.next = head;
                y = y.next;
            }
            head = head.next;
        }
        y.next = null;
        
        k.next = large.next;
        
        return small.next;
    }
}
