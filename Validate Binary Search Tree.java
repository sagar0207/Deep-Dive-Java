/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {

        return outcome(root, Long.MAX_VALUE, Long.MIN_VALUE);
        
    }
    
    static boolean outcome(TreeNode root, Long max, Long min)
    {
        if(root == null)
            return true;
        
        if(root.val >= max || root.val <= min)
            return false;
            
        return (outcome(root.left, Long.valueOf(root.val), min) && outcome(root.right, max, Long.valueOf(root.val)));
    }
}
