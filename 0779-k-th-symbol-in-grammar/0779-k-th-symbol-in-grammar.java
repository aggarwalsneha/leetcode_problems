class Solution {
    public int kthGrammar(int n, int k) {
        if(n==1)
            return 0;
        int symbol=1;
        for(int i=n;i>1;i--){
            int total=(int)Math.pow(2,i-1);
            int half=total/2;
            if(k>half){
                symbol=1-symbol;
                k-=half;
            }
        }
        if(symbol!=0)
            return 0;
        return 1;
    }
}