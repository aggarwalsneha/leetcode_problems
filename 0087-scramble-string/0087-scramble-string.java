class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.equals(s2))
            return true;
        if(s1.length()!=s2.length())
            return false;
        Map<String,Boolean>hm=new HashMap<>();
        return solve(s1,s2,hm);
    }
    boolean solve(String s1,String s2,Map<String,Boolean>hm)
    {
        if(s1.equals(s2))
            return true;
        if(s1.length()<=1 || s2.length()<=1)
            return false;
        boolean flag=false;
        String k=s1+"-"+s2;
        if(hm.containsKey(k))
            return hm.get(k);
        for(int i=1;i<=s1.length()-1;i++)
        {
            if(solve(s1.substring(0,i),s2.substring(0,i),hm) && solve(s1.substring(i),s2.substring(i),hm)){
                flag=true;
                break;
            }
            if(solve(s1.substring(0,i),s2.substring(s1.length()-i),hm) && 
               solve(s1.substring(i),s2.substring(0,s1.length()-i),hm)){
                flag=true;
                break;
            }
        }
        hm.put(k,flag);
        return flag;
    }
}