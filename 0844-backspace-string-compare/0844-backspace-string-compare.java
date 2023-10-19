class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> sst=new Stack<>();
        Stack<Character> tst=new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)=='#' && sst.isEmpty())
            continue;
            else if(s.charAt(i)=='#' && !sst.isEmpty())
            sst.pop();
            else
            sst.push(s.charAt(i));
            
        }
        for(int i=0;i<t.length();i++)
        {
            if(t.charAt(i)=='#' && tst.isEmpty())
            continue;
            else if(t.charAt(i)=='#' && !tst.isEmpty())
            tst.pop();
            else
            tst.push(t.charAt(i));  
        }
        String re_s="";
        String re_t="";
        while(!sst.isEmpty())
        re_s+=sst.pop();
        while(!tst.isEmpty())
        re_t+=tst.pop();

        return re_s.equals(re_t);
    }
}