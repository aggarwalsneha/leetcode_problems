class Solution {
    public boolean closeStrings(String word1, String word2) {
        HashMap<Character,Integer> hm1=new HashMap<>();
         HashMap<Character,Integer> hm2=new HashMap<>();
        for(int i=0;i<word1.length();i++)
        {
            hm1.put(word1.charAt(i),hm1.getOrDefault(word1.charAt(i),0)+1);
        }
        for(int i=0;i<word2.length();i++)
        {
            hm2.put(word2.charAt(i),hm2.getOrDefault(word2.charAt(i),0)+1);
        }
        if(!hm1.keySet().equals(hm2.keySet()))
            return false;
        List<Integer> v1=new ArrayList<>(hm1.values());
        List<Integer> v2=new ArrayList<>(hm2.values());
        
        Collections.sort(v1);
        Collections.sort(v2);
        
        return v1.equals(v2);
    }
}