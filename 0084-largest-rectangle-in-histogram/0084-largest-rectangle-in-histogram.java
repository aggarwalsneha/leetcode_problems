class Solution {
    public int largestRectangleArea(int[] heights) {
        int n=heights.length;
        int max=0;
        int[] left=new int[n];
        int[] right=new int[n];
        Stack<Integer>st=new Stack<>();
        for (int i=0;i<n;i++){
            while(!st.empty() && heights[st.peek()]>heights[i]) {
                right[st.peek()]=i;
                st.pop();
            }
            st.push(i);
        }
        while(!st.empty()){
            right[st.peek()] = n;
            st.pop();
        }

        for(int i=0;i<n;i++){
            while(!st.empty() && heights[st.peek()]>=heights[i])
                st.pop();
            if(!st.empty())
                left[i]=st.peek();
            else 
                left[i]=-1;
            st.push(i);
        }
        for(int i=0;i<n;i++)
        {
            max=Math.max(heights[i]*(right[i]-left[i]-1),max);
        }
        return max;
    }
}