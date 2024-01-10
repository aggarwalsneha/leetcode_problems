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
    public int amountOfTime(TreeNode root, int start) {
        Map<Integer,Set<Integer>>map=new HashMap<>();  
        convert(root,0,map);
        Queue<Integer> q=new LinkedList<>(); 
        q.add(start);
        int minute=0;
        Set<Integer>visited=new HashSet<>();
        visited.add(start);
        while(!q.isEmpty()){
            int size=q.size();
            while(size-->0){
                int curr=q.poll();
                for(int num:map.get(curr)){
                    if(!visited.contains(num)){
                        visited.add(num);
                        q.add(num);
                    }
                }
            }
            minute++;
        }
        return minute-1;
    }
    public void convert(TreeNode curr,int parent,Map<Integer,Set<Integer>>map){
        if(curr==null)
            return; 
        if(!map.containsKey(curr.val))
            map.put(curr.val,new HashSet<>());
        Set<Integer>adj=map.get(curr.val);
        if(parent!=0)
            adj.add(parent);
        if(curr.left!=null)
            adj.add(curr.left.val);
        if(curr.right!=null)
            adj.add(curr.right.val);
        convert(curr.left,curr.val,map);
        convert(curr.right,curr.val,map);
    }
}