class Solution {
    public int countNicePairs(int[] nums) {
        Map<Integer,Integer>hm=new HashMap<>();
        int ans=0;
        int mod=(int)1e9+7;
        for(int i=0;i<nums.length;i++){
            int diff=nums[i]-reverse(nums[i]);
            int freq=hm.getOrDefault(diff,0);
            ans=(ans+freq)%mod;
            hm.put(diff,freq+1);
        }
        return ans;
    }
    
    public int reverse(int num){
        int rev=0;
        while(num>0){
            rev=rev*10+num%10;
            num/=10;
        }
        return rev;
    }
}