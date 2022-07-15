class Solution {
    public double myPow(double x, int n) {
    double res=myPow_(x,Math.abs(n));
        if(n<0){
            return 1.0/res;
        }else{
            return res;
        }
    }
    
    public double myPow_(double x, int n){
        if(n==0){
            return 1.0;
        }else if(n==1){
            return x;
        }else{
            double ans=myPow_(x,n/2);
            if(n%2==0){
                return ans*ans;
            }else{
                return ans*ans*x;
            }
        }
    }

}