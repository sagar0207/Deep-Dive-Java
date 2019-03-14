/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
        {
            return null;
        }
        
        Node ptr = head;
        while(ptr!=null)
        {
            Node newnode = new Node(ptr.val);
            
            newnode.next = ptr.next;
            ptr.next = newnode;
            ptr = newnode.next;
        }
        
        ptr = head;
        
        while(ptr!=null)
        {
            ptr.next.random = (ptr.random!=null) ? ptr.random.next : null;
            ptr = ptr.next.next;
        }
        
        Node ptr_old = head;
        Node ptr_new = head.next;
        Node res = head.next;
        
        while(ptr_old!=null)
        {
            ptr_old.next = ptr_old.next.next;
            ptr_new.next = (ptr_new.next!=null) ? ptr_new.next.next : null;
            
            ptr_old = ptr_old.next;
            ptr_new = ptr_new.next;
        }
        return res;
    }
}
