class Solution {
    public int firstMissingPositive(int[] nums) {
        int max=1;
        for(int n:nums)
            max=Math.max(max,n);
        boolean[] p=new boolean[nums.length+1];
        for(int n:nums){
            if(n>0 && n<=nums.length)
            p[n]=true;
        }
        for(int i=1;i<=nums.length;i++)
        {
            if(!p[i])
                return i;
        }
        return max+1;
    }
    void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}