class Solution {
    public int numDecodings(String s) {
        int n1=1,n2=0,n=s.length();
        for(int i=n-1;i>=0;i--){
            int n3=s.charAt(i)=='0' ? 0 : n1;
            if(i<n-1 && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<'7'))
                n3+=n2;
            n2=n1;
            n1=n3;
        }
        return n1; 
    }
}