class Solution {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> st=new Stack<>();
        int n=nums.length;
        int[] ans=new int[nums.length];
        for(int i=2*(nums.length)-1;i>=0;i--)
        {
            while(!st.isEmpty() && st.peek()<=nums[i%n]){
            st.pop();
            }
            if(i%n<nums.length){
             if(st.isEmpty())
                ans[i%n]=-1;
             else
                ans[i%n]=st.peek();
            }
             st.push(nums[i%n]);
            
        }
        return ans;
        
    }
}