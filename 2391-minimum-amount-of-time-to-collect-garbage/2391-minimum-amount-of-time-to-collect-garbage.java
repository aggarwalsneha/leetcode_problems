class Solution {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ans=0;
        Map<Character,Integer> hm=new HashMap<>();
        for(int i=1;i<travel.length;i++)
            travel[i]=travel[i-1]+travel[i];
        for(int i=0;i<garbage.length;i++){
            for(char c:garbage[i].toCharArray())
                hm.put(c,i);
            ans+=garbage[i].length();
        }
        String type="MPG";
        for(char c:type.toCharArray()){
            if(hm.getOrDefault(c,0)!=0)
                ans+=travel[hm.get(c)-1];
        }
        return ans;
    }
}