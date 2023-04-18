class Solution {
    public int removeDuplicates(int[] nums) {
        int ind=0;
        for(int i=0;i<nums.length;i++){
            if(ind<2 || nums[ind-2]<nums[i])
                nums[ind++]=nums[i];
        }
        return ind;
    }
}