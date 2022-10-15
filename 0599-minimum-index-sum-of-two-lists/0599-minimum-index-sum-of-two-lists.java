class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
       HashMap<Integer,List<String>> hm=new HashMap<>();
        for(int i=0;i<list1.length;i++)
        {
            for(int j=0;j<list2.length;j++)
            {
                if(list1[i].equals(list2[j]))
                {
                    if(!hm.containsKey(i+j))
                        hm.put(i+j,new ArrayList<String>());
                    hm.get(i+j).add(list1[i]);
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int key:hm.keySet())
            min=Math.min(min,key);
        String[] ans=new String[hm.get(min).size()];
        ans=hm.get(min).toArray(ans);
        return ans;
        
    }
}