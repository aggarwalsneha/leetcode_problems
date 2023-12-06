class Solution {
    public int totalMoney(int n) {
        int i=1;
        int sum=0;
        while(n>0){
            int N=0;
            int a=i;
            if(n>=7)
                N=7;
            else
                N=n;
            sum=sum+(N*(2*a+N-1)/2);
            n-=7;
            i++;
        }
        return sum;
    }
}