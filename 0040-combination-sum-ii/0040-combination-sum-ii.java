class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        Set<List<Integer>> ans=new HashSet<>();
        solve(0,target,candidates,new ArrayList<>(),ans);
        List<List<Integer>> res=new ArrayList<>(ans);
        return res;
    }
    
    void solve(int ind,int target,int[]arr,List<Integer>temp,Set<List<Integer>> ans)
    {
            if(target==0){
                ans.add(new ArrayList<>(temp));
                return;
            }
        for(int j=ind;j<arr.length;j++){
            if(j>ind && arr[j]==arr[j-1])
                continue;
            if(arr[j]>target)
                break;
            temp.add(arr[j]);
            solve(j+1,target-arr[j],arr,temp,ans);
            temp.remove(temp.size()-1);
        }
    }
}