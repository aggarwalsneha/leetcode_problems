class Solution {
    public int maxProfit(int[] prices) {
        int no_stock=0;
        int one_stock=-prices[0];
        for(int i=1;i<prices.length;i++)
        {
            int new_no_stock;
            int new_one_stock;
            new_no_stock=Math.max(no_stock,one_stock+prices[i]);
            new_one_stock=Math.max(one_stock,no_stock-prices[i]);
            no_stock=new_no_stock;
            one_stock=new_one_stock;
        }
        return no_stock;
    }
}