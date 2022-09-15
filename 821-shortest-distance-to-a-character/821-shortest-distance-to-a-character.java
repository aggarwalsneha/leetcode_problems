class Solution {
    public int[] shortestToChar(String s, char c) {
        int ans[]=new int[s.length()];
        int prev=10000;
        int count;
            for(int i=0;i<s.length();i++)
            {
                if(s.charAt(i)==c)
                    prev=i;
                ans[i]=Math.abs(prev-i);
            }
        for(int i=s.length()-1;i>=0;i--)
        {
            if(s.charAt(i)==c)
                prev=i;
            ans[i]=Math.min(ans[i],Math.abs(prev-i));
        }
        return ans;
    }
}
