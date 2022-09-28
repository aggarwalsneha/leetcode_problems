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
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> printTree(TreeNode root) {
        int h=getHeight(root);
        int n=(int)Math.pow(2,h)-1;
        for(int i=0;i<h;i++)
        {
            String[] str=new String[n];
            Arrays.fill(str,"");
            ans.add(new ArrayList<>(Arrays.asList(str)));
        }
        findPosition(root,0,n-1,0);
        return ans;
    }
    
    public int getHeight(TreeNode root)
    {
        if(root==null)
            return 0;
        return Math.max(getHeight(root.left),getHeight(root.right))+1;
    }
    
    public void findPosition(TreeNode root,int lo,int hi,int row)
    {
        if(root==null)
            return ;
        int ind=(lo+hi)/2;
        ans.get(row).set(ind,Integer.toString(root.val));
        findPosition(root.left,lo,ind-1,row+1);
        findPosition(root.right,ind+1,hi,row+1);
    }
}