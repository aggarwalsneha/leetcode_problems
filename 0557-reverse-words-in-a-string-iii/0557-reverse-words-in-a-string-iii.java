class Solution {
    public String reverseWords(String s) {
        String[] words=s.split(" ");
        String ans="";
        for(int i=0;i<words.length;i++)
        {
            ans+=reverse(words[i])+" ";
        }
        return ans.trim();
    }
    
    public String reverse(String s)
    {
        for(int i=0;i<s.length()/2;i++)
        {
            char temp=s.charAt(i);
            s=s.substring(0,i)+s.charAt(s.length()-i-1)+s.substring(i+1,s.length());
            s=s.substring(0,s.length()-i-1)+temp+s.substring(s.length()-i,s.length());
        }
        return s;
    }
}