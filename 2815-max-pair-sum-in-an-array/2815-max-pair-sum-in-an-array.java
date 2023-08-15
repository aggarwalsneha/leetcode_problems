class Solution {
    public int maxSum(int[] nums) {
        int ans=-1;
        Map<Integer,List<Integer>>hm=new HashMap<>();
        for(int n:nums){
            int t=n,max=0;
            while(t!=0){
                max=Math.max(max,t%10);
                t/=10;
            }
            if(!hm.containsKey(max))
                hm.put(max,new ArrayList<>());
            hm.get(max).add(n);
        }
        for(Map.Entry<Integer,List<Integer>>e:hm.entrySet()){
            e.getValue().sort(Comparator.reverseOrder());
            if(e.getValue().size()>=2)
                ans=Math.max(ans,e.getValue().get(0)+e.getValue().get(1));
        }
        return ans;
    }
}