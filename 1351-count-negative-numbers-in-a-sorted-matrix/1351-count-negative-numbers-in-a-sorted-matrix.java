class Solution {
    public int countNegatives(int[][] grid) {
        int count=0;
        for(int i=0;i<grid.length;i++){
            int c=firstNegative(grid[i]);
            count+=grid[i].length-c;
        }
        return count;
    }
    
    public int firstNegative(int[] arr){
        int ans=arr.length;
        int l=0,h=arr.length-1,mid=0;
        while(l<=h){
            mid=(l+h)/2;
            if(arr[mid]<0){
                ans=mid;
                h=mid-1;
            }
            else{
                l=mid+1;
            }
        }
        return ans;
    }
}