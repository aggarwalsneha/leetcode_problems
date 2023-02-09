class Solution {
    int count=0;
    public int countArrangement(int n) {
        int[]nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=i+1;
        permute(nums,0);
        return count;
    }
    
    void permute(int[]nums,int ind)
    {
        if(ind==nums.length)
            count++;
        for(int j=ind;j<nums.length;j++)
        {
            swap(nums,ind,j);
            if(nums[ind]%(ind+1)==0 || (ind+1)%nums[ind]==0)
                permute(nums,ind+1);
            swap(nums,ind,j);
        }
    }
    
    void swap(int[]nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}