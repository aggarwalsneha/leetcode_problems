class Solution {
    public int[] replaceElements(int[] arr) {
        int[] ans=new int[arr.length];
        for(int i=arr.length-1;i>=0;i--){
            if(i==arr.length-1)
                ans[i]=-1;
            else
                ans[i]=Math.max(ans[i+1],arr[i+1]);
        }
        return ans;
    }
}