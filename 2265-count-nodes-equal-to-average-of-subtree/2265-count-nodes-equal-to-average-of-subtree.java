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
    int count=0;
    public int averageOfSubtree(TreeNode root) {
        count=0;
        solve(root);
        return count;
    }
    
    public int[] solve(TreeNode root){
        if(root==null)
            return new int[]{0,0};
        int sum=0;
        int level=1;
        sum+=root.val;
        if(root.left!=null){
            int[] a=solve(root.left);
            sum+=a[0];
            level+=a[1];
        }
        if(root.right!=null){
            int[]a=solve(root.right);
            sum+=a[0];
            level+=a[1];
        }
        if(sum/level==root.val)
            count++;
        return new int[]{sum,level};
    }
}