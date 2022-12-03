import java.util.Map.Entry;
class Solution {
    public String frequencySort(String s) {
        String ans="";
        HashMap<Character,Integer> hm=new HashMap<>();
        for(int i=0;i<s.length();i++)
            hm.put(s.charAt(i),hm.getOrDefault(s.charAt(i),0)+1);
       List<Map.Entry<Character, Integer>> fr = new ArrayList<>(hm.entrySet());
        Collections.sort(fr,(a,b)->b.getValue()-a.getValue());
        for(Map.Entry<Character, Integer> e: fr) {
            for(int i=0;i<e.getValue();i++) 
                ans+=e.getKey();
        }
        return ans;
    }
}