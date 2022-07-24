class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st=new Stack<>();

        int[] ans=new int[prices.length];
        st.push(0);
        for(int i=prices.length-1;i>=0;i--)
        {
            while(st.peek()>prices[i]){
            st.pop();
            }

        ans[i]=prices[i]-st.peek();
        st.push(prices[i]);
        }
        return ans;
    }
}