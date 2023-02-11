class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,List<String>>hm=new HashMap<>();
        for(int i=0;i<strs.length;i++)
        {
            char[] s=strs[i].toCharArray();
            Arrays.sort(s);
            String st=new String(s);
            if(hm.containsKey(st))
                hm.get(st).add(strs[i]);
            else{
                hm.put(st,new ArrayList<>());
                hm.get(st).add(strs[i]);
            }
        }
        return new ArrayList<>(hm.values());
    }
}