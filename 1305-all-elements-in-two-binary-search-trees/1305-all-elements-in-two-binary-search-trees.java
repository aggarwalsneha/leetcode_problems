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
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> arr1=new ArrayList<>();
        List<Integer> arr2=new ArrayList<>();
        getElements(root1,arr1);
        getElements(root2,arr2);
        List<Integer> ans=new ArrayList<>();
        int i=0,j=0;
        while(i<arr1.size()&&j<arr2.size())
        {
            if(arr1.get(i)<arr2.get(j)){
                ans.add(arr1.get(i));
                i++;
            }
            else{
                ans.add(arr2.get(j));
                j++;
            }
        }
        while(i<arr1.size())
        {
             ans.add(arr1.get(i));
                i++;
        }
         while(j<arr2.size())
        {
             ans.add(arr2.get(j));
                j++;
        }
        
        return ans;
    }
    
    public void getElements(TreeNode root, List<Integer> arr)
    {
        if(root==null)
            return ;
        getElements(root.left,arr);
            arr.add(root.val);
        getElements(root.right,arr);
    }
}