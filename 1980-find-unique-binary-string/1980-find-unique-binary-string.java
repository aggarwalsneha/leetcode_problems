class Solution {
    public String findDifferentBinaryString(String[] nums) {
        Set<Integer> hs=new HashSet();
        for(String n:nums) {
            hs.add(Integer.parseInt(n,2));
        }
        int n=nums.length;
        for(int i=0;i<=n;i++) {
            if(!hs.contains(i)) {
                String ans=Integer.toBinaryString(i);
                while(ans.length()<n){
                    ans="0"+ans;
                }
                return ans;
            }
        }
        return "";
    }
}