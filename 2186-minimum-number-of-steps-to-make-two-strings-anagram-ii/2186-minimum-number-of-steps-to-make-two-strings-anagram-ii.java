class Solution {
    public int minSteps(String s, String t) {
        HashMap<Character,Integer>hm1=new HashMap<>();
        HashMap<Character,Integer>hm2=new HashMap<>();
        
        for(char ch:s.toCharArray())
            hm1.put(ch,hm1.getOrDefault(ch,0)+1);
        for(char ch:t.toCharArray())
            hm2.put(ch,hm2.getOrDefault(ch,0)+1);
        int steps=0;
        
        for(char ch:s.toCharArray()){
            int f1=hm2.getOrDefault(ch,0);
            int f2=hm1.getOrDefault(ch,0);
            steps+=Math.abs(f2-f1);
            hm1.remove(ch);
            hm2.remove(ch);
        }
        for(char ch:t.toCharArray()){
            int f1=hm2.getOrDefault(ch,0);
            int f2=hm1.getOrDefault(ch,0);
            steps+=Math.abs(f2-f1);
            hm1.remove(ch);
            hm2.remove(ch);
        }
        return steps;
    }
}