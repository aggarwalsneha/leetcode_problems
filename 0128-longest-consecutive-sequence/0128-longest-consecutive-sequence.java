class Solution {
    public int longestConsecutive(int[] nums) {
        HashMap<Integer,Integer>hm=new HashMap<>();
        int max=0;
        for(int num:nums)
        {
            if(!hm.containsKey(num))
            {
                int ls=hm.getOrDefault(num-1,0);
                int rs=hm.getOrDefault(num+1,0);
                int curr=ls+rs+1;
                hm.put(num,curr);
                hm.put(num-ls,curr);
                hm.put(num+rs,curr);
                // if(hm.contains(num-1))
                //     hm.put(num-1,hm.get(num-1)+1);
                // if(hm.contains(num+1))
                //     hm.put(num+1,hm.get(num+1)+1);
                max=Math.max(max,curr);
            }
        }
        return max;
    }
}