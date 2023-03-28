/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode>pm=new HashMap<>();
        Queue<TreeNode>q=new LinkedList<>();
        Map<TreeNode,Boolean>vis=new HashMap<>();
        markParent(root,pm);
        q.offer(target);
        vis.put(target,true);
        int curr_level=0;
        while(!q.isEmpty())
        {
            int size=q.size();
            if(curr_level==k)
                break;
            curr_level++;
            for(int i=0;i<size;i++)
            {
                TreeNode curr=q.poll();
                if(curr.left!=null && !vis.containsKey(curr.left)){
                    q.offer(curr.left);
                    vis.put(curr.left,true);
                }
                if(curr.right!=null && !vis.containsKey(curr.right)){
                    q.offer(curr.right);
                    vis.put(curr.right,true);
                }
                if(pm.get(curr)!=null && !vis.containsKey(pm.get(curr))){
                    q.offer(pm.get(curr));
                    vis.put(pm.get(curr),true);
                }
            }
        }
        List<Integer>ans=new ArrayList<>();
        while(!q.isEmpty())
        {
            ans.add(q.poll().val);
        }
        return ans;
    }
    
    void markParent(TreeNode root,Map<TreeNode,TreeNode>pm)
    {
        Queue<TreeNode>q=new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty())
        {
            TreeNode curr=q.poll();
            if(curr.left!=null)
            {
                q.offer(curr.left);
                pm.put(curr.left,curr);
            }
            if(curr.right!=null)
            {
                q.offer(curr.right);
                pm.put(curr.right,curr);
            }
        }
    }
}