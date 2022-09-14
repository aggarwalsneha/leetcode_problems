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
    int ans=Integer.MAX_VALUE,prev=-1;
    public int minDiffInBST(TreeNode root) {
       return inorder(root);
    }
    
    public int inorder(TreeNode root)
    {
        if(root!=null){
            inorder(root.left);
        if(prev!=-1)
        ans=Math.min(Math.abs(root.val-prev),ans);
              prev=root.val;
        inorder(root.right);
        return ans;
        }
        return ans;
    }
}