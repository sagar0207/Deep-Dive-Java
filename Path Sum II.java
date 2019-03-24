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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null)
            return result;
        helperFunc(root, sum, 0, list, result);
        return result;
    }
    
    static void helperFunc(TreeNode root, int sum, int pathsum, List<Integer> list, List<List<Integer>> result)
    {
        if(root == null)
        {    
            return;
        }
        pathsum += root.val;
        list.add(root.val);
        if(pathsum == sum && root.left == null && root.right == null)
        {
            result.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
        else
        {
            helperFunc(root.left, sum, pathsum, list, result);
            helperFunc(root.right, sum, pathsum, list, result);
        }
        list.remove(list.size()-1);
        
    }
}
