/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public TreeNode increasingBST(TreeNode root) {
        TreeNode ans=new TreeNode(-1),head=ans;
        List<Integer> arr=new ArrayList();
        inorder(root,arr);
        for(int i:arr)
        {
            head.right=new TreeNode(i);
            head=head.right;
        }
        return ans.right;
    }
    
    public void inorder(TreeNode root,List<Integer> arr)
    {
        if(root==null)
            return;
        inorder(root.left,arr);
        arr.add(root.val);
        inorder(root.right,arr);
    }
}