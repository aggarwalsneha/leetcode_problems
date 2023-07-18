class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        ans=new ArrayList<>();
        solve(nums,0,new ArrayList<>(),false);
        return ans;
    }
    public void solve(int[]nums,int ind,List<Integer>temp,boolean prev)
    {
     if(ind==nums.length)
     {
         ans.add(new ArrayList<>(temp));
         return;
     }
        solve(nums,ind+1,temp,false);
        if(ind>=1 && nums[ind]==nums[ind-1] && !prev)
            return;
        temp.add(nums[ind]);
        solve(nums,ind+1,temp,true);
        temp.remove(temp.size()-1);
        
    }
}