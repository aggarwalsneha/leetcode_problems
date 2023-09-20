class Solution {
    public int minOperations(int[] nums, int x) {
        int sum=0;
        for(int n:nums)
            sum+=n;
        int target=sum-x;
        if(target==0)
            return nums.length;
        int res=Integer.MIN_VALUE;
        Map<Integer,Integer>hm=new HashMap<>();
        hm.put(0,-1);
        sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            if(hm.containsKey(sum-target))
                res=Math.max(res,i-hm.get(sum-target));
            hm.put(sum,i);
        }
        return res==Integer.MIN_VALUE? -1: nums.length-res;
    }
}