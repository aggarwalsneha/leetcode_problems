class Solution {
    public boolean isAnagram(String s1, String s2) {
        if(s2.length()!=s1.length())
            return false;
        HashMap<Character,Integer> hmap = new HashMap<>();
        for(int i=0;i<s1.length();i++){
            if(hmap.containsKey(s1.charAt(i))){
                hmap.put(s1.charAt(i),hmap.get(s1.charAt(i))+1);
            }
            else{
                hmap.put(s1.charAt(i),1);
            }
        }
        for(int i=0;i<s2.length();i++){
            if(!hmap.containsKey(s2.charAt(i)))
                return false;
            else{
                if(hmap.get(s2.charAt(i))==1)
                    hmap.remove(s2.charAt(i));
                else
                    hmap.put(s2.charAt(i),hmap.get(s2.charAt(i))-1);
            }
        }
        return true;
    }
}