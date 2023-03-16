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
    int p=-1,gp=-1,ans=0;
    public int sumEvenGrandparent(TreeNode root) {
        count(root,p,gp);
        return ans;
    }
    
    public void count(TreeNode root,int p,int gp)
    {
        if(root==null)
            return;
        if(gp%2==0)
            ans+=root.val;
        count(root.left,root.val,p);
        count(root.right,root.val,p);
    }
}