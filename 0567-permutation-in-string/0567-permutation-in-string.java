class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length())
            return false;
       int[] hm1=new int[26];
       int[] hm2=new int[26];
        for(int i=0;i<s1.length();i++)
        {
            hm1[s1.charAt(i)-'a']++;
            hm2[s2.charAt(i)-'a']++;
        }
        for(int i=0;i<s2.length()-s1.length();i++)
        {
            if(match(hm1,hm2))
                return true;
            hm2[s2.charAt(i+s1.length())-'a']++;
            hm2[s2.charAt(i)-'a']--;
        }
        return match(hm1,hm2);
    }
    
    public boolean match(int[] hm1,int[] hm2)
    {
        for(int i=0;i<26;i++)
        {
            if(hm1[i]!=hm2[i])
                return false;
        }
        return true;
    }
}