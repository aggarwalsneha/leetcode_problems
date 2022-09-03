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
    int k=0;
    public void recoverTree(TreeNode root) {
         List<Integer> arr=new ArrayList<>();
        arr= inorder(root,arr);
       Integer[] a = new Integer[arr.size()];
        a = arr.toArray(a);
        Arrays.sort(a);
        matchTree(root,a);
    }
    
    public List<Integer> inorder(TreeNode root,List<Integer> in)
    {
        if(root==null)
            return null;
       inorder(root.left,in);
        in.add(root.val);
        inorder(root.right,in);
        return in;
        
    }
    
    public void matchTree(TreeNode root,Integer[] arr)
    {
        if(root==null)
            return;
        matchTree(root.left,arr);
        if(root.val!=arr[k])
           root.val=arr[k];
        k++;
        matchTree(root.right,arr);
    }
}