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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)
            return root;
        TreeNode left_val = lowestCommonAncestor(root.left, p, q);
        TreeNode right_val = lowestCommonAncestor(root.right, p, q);
        
        if(left_val!=null && right_val!=null)
            return root;
        else if(left_val == null && right_val == null)
            return null;
        else 
            return (left_val!=null)?left_val:right_val;
            
    }
}
