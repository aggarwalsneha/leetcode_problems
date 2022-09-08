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
    public List<String> binaryTreePaths(TreeNode root) {
        List <String> ans=new ArrayList<>();
        if(root==null)
            return null;
        String result=root.val+"";
        if(root.left==null && root.right==null)
        {   
           ans.add(result);
            return ans;
        }
        if(root.left!=null)
            path(root.left,result,ans);
        if(root.right!=null)
            path(root.right,result,ans);
        return ans;
       
    }
    
    public void path(TreeNode root,String result,List ans)
    {
        result+="->"+root.val;
        if(root.left==null && root.right==null)
            ans.add(result);
        if(root.left!=null)
            path(root.left,result,ans);
        if(root.right!=null)
            path(root.right,result,ans);
    }
}