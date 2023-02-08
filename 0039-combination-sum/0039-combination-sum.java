class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        solve(0,target,candidates,new ArrayList<>(),ans);
        return ans;
    }
    
    void solve(int ind,int target,int[]arr,List<Integer>temp,List<List<Integer>> ans)
    {
        if(ind==arr.length){
            if(target==0){
                ans.add(new ArrayList<>(temp));
            }
            return;
        }
        if(arr[ind]<=target){
            temp.add(arr[ind]);
            solve(ind,target-arr[ind],arr,temp,ans);
            temp.remove(temp.size()-1);
        }
        solve(ind+1,target,arr,temp,ans);
    }
}