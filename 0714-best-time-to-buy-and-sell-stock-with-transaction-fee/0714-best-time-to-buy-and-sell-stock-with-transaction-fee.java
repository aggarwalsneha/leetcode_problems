class Solution {
    public int maxProfit(int[] prices, int fee) {
        int prevNot=0,prev=0,currNot=0,curr=0;
        for(int i=prices.length-1;i>=0;i--){
            currNot=Math.max(prices[i]-fee+prev,prevNot);
            curr=Math.max(-prices[i]+prevNot,prev);
            prev=curr;
            prevNot=currNot;
        }
        return prev;
    }
}