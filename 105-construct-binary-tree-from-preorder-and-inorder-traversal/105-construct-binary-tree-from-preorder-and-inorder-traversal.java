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
    int[] pre;
    Map<Integer,Integer> iomap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
         for(int i=0;i<inorder.length;i++)
         {
            iomap.put(inorder[i], i);
         }
        pre=new int[preorder.length];
         for(int i=0;i<preorder.length;i++)
         {
            pre[i]=preorder[i];
         }
        
        return get_Tree(0,inorder.length-1,0,preorder.length-1);
    }
    
    public TreeNode get_Tree(int prestart,int preend,int instart,int inend)
    {
        if(prestart>=pre.length) return null;
        if(prestart>preend)
        return null;
        int io_index=iomap.get(pre[prestart]);
        int l=io_index-instart;
        int r=inend-io_index;
        TreeNode root=new TreeNode(pre[prestart]);
        root.left=get_Tree(prestart+1,prestart+l,instart,io_index-1);
        root.right=get_Tree(prestart+l+1,preend,io_index+1,inend);
        
        return root;
    }
    
}