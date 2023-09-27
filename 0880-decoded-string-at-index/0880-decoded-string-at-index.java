class Solution {
    public String decodeAtIndex(String s, int k) {
        int i=0;
        long n=0;
        for(i=0;n<k;i++){
            n=Character.isDigit(s.charAt(i))?n*(s.charAt(i)-'0'):n+1;
        }
        while(i-->0){
            if(Character.isDigit(s.charAt(i))){
                n/=s.charAt(i)-'0';
                k%=n;
            }
            else{
                if(k%n==0)
                    break;
                n--;
            }
        }
        return Character.toString(s.charAt(i));
    }
}