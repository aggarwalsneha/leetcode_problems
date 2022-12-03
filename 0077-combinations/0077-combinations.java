class Solution {
    List<List<Integer>> ans=new ArrayList<>();
    public List<List<Integer>> combine(int n, int k) {
        List<Integer> in=new ArrayList<>();
        getcomb(1,in,n,k);
        return ans;
    }
    
     public void getcomb(int start,List<Integer> in,int n,int k)
    {
        if(in.size()==k)
            ans.add(new ArrayList<>(in));
        // if(start>)
            // return;
        for(int i=start;i<=n;i++)
        {
            in.add(i);
            getcomb(i+1,in,n,k);
            in.remove(in.size()-1);
        }
         
     }
}