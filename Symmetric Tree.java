/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 
 
 
 /*Approach 1: Iterative
Time complexity : O(n). 
Because we traverse the entire input tree once, the total run time is O(n), where nn is the total number of nodes in the tree.
Space complexity : There is additional space required for the search queue. In the worst case, we have to insert O(n) nodes in the queue. 
Therefore, space complexity is O(n).
 */
class Solution {
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        
        queue.add(root);
        queue.add(root);
        
        while(!queue.isEmpty())
        {
            TreeNode t1 = queue.poll();
            TreeNode t2 = queue.poll();
            if(t1 == null &&  t2 == null)
                continue;
            if(t1 == null || t2 == null)
                return false;
            if(t1.val != t2.val)
                return false;
            queue.add(t1.left);
            queue.add(t2.right);
            queue.add(t1.right);
            queue.add(t2.left);
        }
        return true;
    }
}

/*Approach 2: Recursive
Time complexity : O(n).
Because we traverse the entire input tree once, the total run time is O(n), where nn is the total number of nodes in the tree.
Space complexity : The number of recursive calls is bound by the height of the tree. In the worst case, the tree is linear and the height is in O(n).
Therefore, space complexity due to recursive calls on the stack is O(n) in the worst case. 

*/

public boolean isSymmetric(TreeNode root) {
    Queue<TreeNode> q = new LinkedList<>();
    q.add(root);
    q.add(root);
    while (!q.isEmpty()) {
        TreeNode t1 = q.poll();
        TreeNode t2 = q.poll();
        if (t1 == null && t2 == null) continue;
        if (t1 == null || t2 == null) return false;
        if (t1.val != t2.val) return false;
        q.add(t1.left);
        q.add(t2.right);
        q.add(t1.right);
        q.add(t2.left);
    }
    return true;
}
