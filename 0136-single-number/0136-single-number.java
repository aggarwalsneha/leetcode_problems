import java.util.Map.Entry;
class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer,Integer> hm=new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            if(hm.containsKey(nums[i]))
                hm.put(nums[i],hm.get(nums[i])+1);
            else
                hm.put(nums[i],1);
        }
       for(Entry<Integer,Integer> entry: hm.entrySet())
        {
            if(entry.getValue()==1)
                return entry.getKey();
        }
        return 0;
    }
}