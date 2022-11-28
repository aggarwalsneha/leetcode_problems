class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        HashMap<Integer,Integer> l=new HashMap<>();
        List<List<Integer>> ans=new ArrayList<>();
        HashSet<Integer> seen=new HashSet<>();
        for(int [] match:matches)
        {
            seen.add(match[0]);
            seen.add(match[1]);
            l.put(match[1],l.getOrDefault(match[1],0)+1);
        }
        ans.add(new ArrayList<Integer>());
         ans.add(new ArrayList<Integer>());
        for(int p:seen)
        {
            if(!l.containsKey(p))
                ans.get(0).add(p);
            else if(l.get(p)==1)
                ans.get(1).add(p);
        }
        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}