class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        HashMap<Integer,Integer> hmap=new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++)
        {
           if(hmap.containsKey(arr[i]))
               hmap.put(arr[i],hmap.get(arr[i])+1);
            else
                hmap.put(arr[i],1);
        }
      HashSet<Integer> hset=new HashSet<>(hmap.values());
        return hset.size()==hmap.size();
    }
}