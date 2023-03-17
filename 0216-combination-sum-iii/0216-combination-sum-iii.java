class Solution {
    List<List<Integer>>ans=new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        generate(1,new ArrayList<>(),k,n);
        return ans;
        
    }
    public void generate(int ind,List<Integer>temp,int k,int target)
    {
        if(temp.size()==k && target==0){
            ans.add(new ArrayList<>(temp));
            return;
        }
        for(int i=ind;i<=9;i++)
        {
            if(i>target)
                continue;
            temp.add(i);
            generate(i+1,temp,k,target-i);
            temp.remove(temp.size()-1);
        }
    }
}