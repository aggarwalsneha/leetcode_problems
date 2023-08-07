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
    static int cams=0;
    public int minCameraCover(TreeNode root) {
        cams=0;
        if(solve(root)==-1)
            cams++;
        return cams;
    }
    
    public int solve(TreeNode root){
        if(root==null)
            return 1;
        int left=solve(root.left);
        int right=solve(root.right);
        
        if(left==-1 || right==-1){
            cams++;
            return 0;
        }
        if(left==0 || right==0)
            return 1;
        return -1;    
    }
}