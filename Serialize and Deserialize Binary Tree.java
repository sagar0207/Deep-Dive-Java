/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rserialize(root, "");
    }
    public String rserialize(TreeNode root, String str)
    {
        if(root == null)
            str +="null,";
        else
        {
            str +=str.valueOf(root.val) + ",";
            str = rserialize(root.left, str);
            str = rserialize(root.right, str);
        }
        return str;
    }
    public TreeNode rdeserialize(List<String> l) 
    {
        if(l.get(0).equals("null"))
        {
            l.remove(0);
            return null;
        }
        
        TreeNode root = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        root.left = rdeserialize(l);
        root.right = rdeserialize(l);
        
        return root;
    }
    
    
    
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        List<String> data_list = new LinkedList<String>(Arrays.asList(arr));
        return rdeserialize(data_list);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
