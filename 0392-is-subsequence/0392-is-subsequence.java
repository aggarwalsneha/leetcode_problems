class Solution {
    public boolean isSubsequence(String s, String t) {
        if(s.equals(""))
        return true;
        int k=0;
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)==s.charAt(k))
            k++;
            if(k==s.length())
            return true;
        }
        return false;
    }
}