class Solution {
    public boolean makeEqual(String[] words) {
        Map<Character,Integer> hm=new HashMap<>();
        int n=words.length;
        for(String s:words){
            for(int i=0;i<s.length();i++){
                char ch=s.charAt(i);
                hm.put(ch,hm.getOrDefault(ch,0)+1);
            }
        }
        for(Map.Entry<Character,Integer> e:hm.entrySet()){
            if(e.getValue()%n!=0)
                return false;
        }
        return true;
    }
}