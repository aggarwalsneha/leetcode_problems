class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String str=paragraph.replaceAll("[^a-zA-Z0-9]"," ").toLowerCase();
        String[] words=str.split("\\s+");
        HashSet<String> bannedW=new HashSet();
        for(String w:banned)
            bannedW.add(w);
        HashMap<String,Integer> hm=new HashMap();
        for(String w:words)
        {
            if(!bannedW.contains(w))
                hm.put(w,hm.getOrDefault(w,0)+1);
        }
        return Collections.max(hm.entrySet(),Map.Entry.comparingByValue()).getKey();
    }
}