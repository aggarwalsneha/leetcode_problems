class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> in=new ArrayList<>();
        boolean[] seen=new boolean[nums.length];
        getPermute(ans,in,seen,nums);
        return ans;
    }
    
    public void getPermute(List<List<Integer>> ans,List<Integer> in,boolean[] seen,int[] nums)
    {
        if(in.size()==nums.length)
        {
            ans.add(new ArrayList<>(in));
            return;
        }
        for(int i=0;i<nums.length;i++)
        {
            if(!seen[i])
            {
                seen[i]=true;
                in.add(nums[i]);
                getPermute(ans,in,seen,nums);
                in.remove(in.size()-1);
                seen[i]=false;
            }
        }
    }
}