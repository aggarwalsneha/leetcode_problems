class Solution {
    public int maximumScore(int[] nums, int k) {
        int n=nums.length;
        int[] left=new int[n];
        int[] right=new int[n];
        Arrays.fill(left,-1);
        Arrays.fill(right,n);
        Stack<Integer>st=new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
                left[st.pop()]=i;
            st.push(i);
        }
        st=new Stack<>();
        for(int i=0;i<n;i++){
            while(!st.isEmpty() && nums[st.peek()]>nums[i])
                right[st.pop()]=i;
            st.push(i);
        }
        int ans=0;
        for(int i=0;i<n;i++){
            if(left[i]<k && right[i]>k)
                ans=Math.max(ans,nums[i]*(right[i]-left[i]-1));
        }
        return ans;
    }
}