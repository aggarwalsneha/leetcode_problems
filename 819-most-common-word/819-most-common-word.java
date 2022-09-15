class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String str=paragraph.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase();
        String[] words=str.split("\\s+");
        HashSet<String> bannedW=new HashSet();
        for(String w:banned)
            bannedW.add(w);
        HashMap<String,Integer> hm=new HashMap();
        int max=0;
        String ans="";
        for(String w:words)
        {
            if(!bannedW.contains(w))
            {
                hm.put(w,hm.getOrDefault(w,0)+1);
            if (hm.get(w)>=max) {
                max=hm.get(w);
                ans=w;
            }
            }
        }
        return ans;
    }
}