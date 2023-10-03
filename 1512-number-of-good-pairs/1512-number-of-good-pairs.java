class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i:nums)
            hm.put(i,hm.getOrDefault(i,0)+1);
        int total=0;
        for(Map.Entry<Integer,Integer> e:hm.entrySet()){
            if(e.getValue()>1){
                int n=e.getValue();
                total+=((n*(n-1))/2);
            }
        }
        return total;
    }
}