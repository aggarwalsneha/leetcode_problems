class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] smap=new int[26];
        int[] pmap=new int[26];
        List<Integer> res=new ArrayList<>();
        if(p.length()>s.length() || s.length()==0)
        return res;
        for(int i=0;i<p.length();i++){
        pmap[p.charAt(i)-'a']++;
        smap[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(pmap,smap))
        res.add(0);
        for(int i=p.length();i<s.length();i++)
        {
            smap[s.charAt(i)-'a']++;
            smap[s.charAt(i-p.length())-'a']--;
            if(Arrays.equals(pmap,smap))
            res.add(i+1-p.length());
        }
        return res;
    }

}