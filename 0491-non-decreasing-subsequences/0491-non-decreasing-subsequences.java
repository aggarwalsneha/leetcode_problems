class Solution {
    List<List<Integer>>res=new ArrayList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        helper(nums,0,new ArrayList<>());
        return res;
    }
    
    public void helper(int[]nums,int index,List<Integer>ans)
    {
        if(index>=nums.length)
        {
            if (ans.size()>1)
                res.add(new ArrayList<>(ans));
            return;
        } 
        
        if(ans.isEmpty()||nums[index]>=ans.get(ans.size()-1))
        {
            ans.add(nums[index]);
            helper(nums,index+1,ans);
            ans.remove(ans.size()- 1);
        }
        if(index>0 && ans.size()>0 && nums[index]==ans.get(ans.size()-1))
            return;
        helper(nums,index + 1,ans);
    }
}