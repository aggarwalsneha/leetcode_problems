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
    public List<TreeNode> generateTrees(int n) {
        if(n==0)
            return new LinkedList<>();
        return generate(1,n);
    }
    
    List<TreeNode> generate(int lo,int hi){
        List<TreeNode>ans=new LinkedList<>();
        if(lo>hi){
            ans.add(null);
            return ans;
        }
        for(int i=lo;i<=hi;i++){
            List<TreeNode> left=generate(lo,i-1);
            List<TreeNode> right=generate(i+1,hi);
            
            for(TreeNode l:left){
                for(TreeNode r:right){
                    TreeNode root=new TreeNode(i);
                    root.left=l;
                    root.right=r;
                    ans.add(root);
                }
            }
        }
        return ans;
    }
}