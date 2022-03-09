class Solution {
    public int searchInsert(int[] nums, int target) {
        int lb=0;
        int ub=nums.length-1;
        int middle=0;
        while(lb<=ub){
             
        
        if(nums[middle]==target)
            break;
        else if(nums[middle]>target)
        {
            ub=middle-1;
        }
        else if(nums[middle]<target)
        {
            lb=middle+1;
        }
            middle=(lb+ub)/2;
            
    }
        if(nums[middle]==target)
            return middle;
        else if(nums[0]>target)
            return 0;
        else if(nums[nums.length-1]<target)
            return nums.length;
        else
            return middle+1;
            
            
    }
}
