class Solution {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans=new ArrayList();
        for(int i=0;i<l.length;i++){
            int[] arr=new int[r[i]-l[i]+1];
            for(int j=0;j<arr.length;j++) {
                arr[j]=nums[l[i]+j];
            }
            ans.add(check(arr));
        }
        return ans;
    }
    
    public boolean check(int[] arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        Set<Integer>hs=new HashSet<>();
        for(int num:arr){
            min=Math.min(num,min);
            max=Math.max(num,max);
            hs.add(num);
        }
        if((max-min)%(arr.length-1)!=0)
            return false;
        int diff=(max-min)/(arr.length-1);
        int curr=min+diff;
        while(curr<max){
            if(!hs.contains(curr))
                return false;
            curr+=diff;
        }
        return true;
    }
}