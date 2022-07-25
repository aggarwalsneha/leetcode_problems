class Solution {
    public int maxArea(int[] arr) {
        int ans=0,temp=0;
        int left=0,right=arr.length-1;
        while(left<right)
        {
        temp=(right-left)*Math.min(arr[left],arr[right]);
        ans=Math.max(ans,temp);
        if(arr[left]<arr[right])
        left++;
        else
        right--;
        }
        return ans;
        
    }
}