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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0)
            return null;
        TreeNode root = makeTree(nums, 0, nums.length-1);
        return root;
    } 
    static TreeNode makeTree(int nums[], int low, int high)
    {
        if(low > high)
            return null;
        int mid = (low+high)/2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = makeTree(nums, low, mid-1);
        node.right = makeTree(nums, mid+1, high);
        return node;
    }
}
