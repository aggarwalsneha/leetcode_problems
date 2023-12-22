class Solution {
    public int maxScore(String s) {
        int ones=0,zero=0,ans=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1')
                ones++;
        }
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)=='1')
                ones--;
            else
                zero++;
            ans=Math.max(ans,zero+ones);
        }
        return ans;
    }
}