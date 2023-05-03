class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> s1=new HashSet<>();
        for(int num:nums1)
            s1.add(num);
        Set<Integer> s2=new HashSet<>();
        for(int num:nums2)
            s2.add(num);
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        for(int num:nums1){
            if(!s2.contains(num) && s1.contains(num)){
                temp.add(num);
                s1.remove(num);
            }
        }
        ans.add(temp);
        temp=new ArrayList<>();
        for(int num:nums2){
            if(!s1.contains(num) && s2.contains(num)){
                temp.add(num);
                s2.remove(num);
            }
        }
        ans.add(temp);
        
        return ans;
    }
}