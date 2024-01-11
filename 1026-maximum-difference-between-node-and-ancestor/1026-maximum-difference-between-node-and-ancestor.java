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
      int result=0;
    public int maxAncestorDiff(TreeNode root) {
        if(root==null)
        return 0;
        return helper(root,root.val,root.val);
    }

    public int helper(TreeNode root,int currMax,int currMin)
    {
        if(root==null)
        return currMax-currMin;
        currMax=Math.max(currMax,root.val);
        currMin=Math.min(currMin,root.val);
        return Math.max(helper(root.left,currMax,currMin),helper(root.right,currMax,currMin));
    }
}