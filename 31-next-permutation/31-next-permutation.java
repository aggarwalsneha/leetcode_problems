class Solution {
    public void nextPermutation(int[] nums) {
        if(nums.length<=1)
            return ;
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
            i--;
        if(i>=0)
        {
            int j=nums.length-1;
            while(nums[j]<=nums[i])
            j--;
            Swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
    }
static void Swap(int[] nums,int i,int j)
{
    int temp=nums[i];
    nums[i]=nums[j];
    nums[j]=temp;
}
static void reverse(int[] nums,int i,int j)
{
    while(i<j)
        Swap(nums,i++,j--);
}
}

