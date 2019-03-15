/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0)
        {
            ListNode res = null;
            return res;
        }
        else if(lists.length == 1)
        {
            ListNode res = lists[0];
            return res;
        }
        ListNode l1 = lists[0];
        ListNode l2 = lists[1];
        ListNode res = mergeTwoLists(l1, l2);
        for(int i = 2 ; i<lists.length; i++)
        {
            ListNode l4 = lists[i];
            res = mergeTwoLists(res,l4);
        }
        return res;
        
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null)
            return l2;
        else if(l2==null)
            return l1;
        else if(l1.val < l2.val)
        {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else
        {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
        
    }
}
    
