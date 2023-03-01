class Solution {
    public int[] sortArray(int[] nums) {
        mergeSort(nums,0,nums.length-1);
        return nums;
    }
    public void mergeSort(int[]nums,int l,int h)
    {
        if(l<h)
        {
            int mid=(l+h)/2;
            mergeSort(nums,l,mid);
            mergeSort(nums,mid+1,h);
            merge(nums,l,mid,h);
        }
    }
    public void merge(int[]nums,int l,int mid,int h){
        int left=l;
        int right=mid+1;
        int[]temp=new int[h-l+1];
        int k=0;
        while(left<=mid && right<=h)
        {
            if(nums[left]<=nums[right])
            {
                temp[k++]=nums[left++];
            }
            else
                temp[k++]=nums[right++];
        }
        while(left<=mid)
            temp[k++]=nums[left++];
        while(right<=h)
            temp[k++]=nums[right++];
        
        for(int i=l;i<=h;i++)
            nums[i]=temp[i-l];
    }
}