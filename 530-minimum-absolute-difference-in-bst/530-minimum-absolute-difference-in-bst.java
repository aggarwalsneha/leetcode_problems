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
       ArrayList<Integer> li=new ArrayList<>();
    public int getMinimumDifference(TreeNode root) {
        inorder(root,li);
        int diff=Integer.MAX_VALUE;
        for(int i=1;i<li.size();i++)
            diff=Math.min(diff,li.get(i)-li.get(i-1));
        return diff;
        
    }
    
    public void inorder(TreeNode root,List<Integer> li)
    {
        if(root.left!=null)
            inorder(root.left,li);
        li.add(root.val);
        if(root.right!=null)
            inorder(root.right,li);
        
    }
}