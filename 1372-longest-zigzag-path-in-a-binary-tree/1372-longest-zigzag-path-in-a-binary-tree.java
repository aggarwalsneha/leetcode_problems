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
    public int longestZigZag(TreeNode root) {
      return path(root,0,true);
        
    }
    
    public int path(TreeNode root,int k,boolean isLeft)
    {
        if(root==null)
            return k-1;
        if(isLeft)
            return Math.max(path(root.left,1,true),path(root.right,k+1,false));
        else
            return Math.max(path(root.left,k+1,true),path(root.right,1,false));
    }
}