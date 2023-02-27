class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int ans=1;
        for(int i:nums)
        {
            if(i==ans)
            ans++;
        }
        return ans;

    }
}