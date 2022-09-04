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
     List<Integer> ans=new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
       add(root,0);
      return ans;
        
    }
    
    public void add(TreeNode root,int level)
    {
        if(root==null)
            return;
        if(level==ans.size())
            ans.add(root.val);
        add(root.right,level+1);
        add(root.left,level+1);
    }
}