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
    public boolean isCousins(TreeNode root, int x, int y) {
     Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty())
        {
            int size=q.size();
            int count=0;
            for(int i=0;i<size;i++)
            {
                TreeNode t=q.poll();
                if(t.left!=null && t.right!=null)
                {
                    if((t.left.val==x && t.right.val==y)||(t.left.val==y && t.right.val==x))
                        return false;
                }
                if(t.left!=null && (t.left.val==x || t.left.val==y))
                    count++;
                if(t.right!=null && (t.right.val==x || t.right.val==y))
                    count++;
                
                if(count==2)
                    return true;
                
                if(t.left!=null)
                    q.add(t.left);
                if(t.right!=null)
                    q.add(t.right);
            }
        }
        return false;
    }
}