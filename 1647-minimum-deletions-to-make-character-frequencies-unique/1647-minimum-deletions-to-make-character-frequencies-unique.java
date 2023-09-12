class Solution {
    public int minDeletions(String s) {
        HashMap<Character,Integer>hm=new HashMap<>();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            hm.put(c,hm.getOrDefault(c,0)+1);
        }
        List<Integer> arr=new ArrayList<>(hm.values());
        Set<Integer>freq=new HashSet<>();
        int count=0;
        for(int it:arr){
            if(freq.contains(it)){
                while(freq.contains(it)){
                    it--;
                    count++;
                }
            }
                if(it>0)
                freq.add(it);
        }
        return count;
    }
}