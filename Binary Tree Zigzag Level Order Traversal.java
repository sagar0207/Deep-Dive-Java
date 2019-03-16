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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        Stack<TreeNode> curr = new Stack<TreeNode>();
        Stack<TreeNode> next = new Stack<TreeNode>();
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return res;
        boolean flag = true;
        curr.push(root);
        while(!curr.isEmpty())
        {
            TreeNode x = curr.pop();
            list.add(x.val);
            if(flag)
            {
                if(x.left!= null)
                    next.push(x.left);
                if(x.right!= null)
                    next.push(x.right);
            }
            else
            {
                if(x.right!= null)
                    next.push(x.right);
                if(x.left!= null)
                    next.push(x.left);
            }
            if(curr.isEmpty())
            {
                flag = !flag;
                res.add(new ArrayList<Integer>(list));
                Stack<TreeNode> temp = curr;
                curr = next;
                next = temp;
                list.removeAll(list);
            }    
        }
        return res;
    }
}
