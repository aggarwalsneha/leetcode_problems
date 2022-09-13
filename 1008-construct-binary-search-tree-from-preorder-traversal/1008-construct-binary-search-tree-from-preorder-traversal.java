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
    int index=0;
    public TreeNode bstFromPreorder(int[] preorder) {
        int l=Integer.MIN_VALUE;
        int r=Integer.MAX_VALUE;
        return bst(preorder,l,r);
    }
    public TreeNode bst(int[] pre,int l,int r)
    {
     if(index>=pre.length)
         return null;
     if(pre[index]<l || pre[index]>r)
         return null;
    TreeNode root=new TreeNode(pre[index++]);
    root.left=bst(pre,l,root.val);
    root.right=bst(pre,root.val,r);
        return root;
    }
}