class Solution {
    public List<String> buildArray(int[] target, int n) {
        int i=1;
        List<String>ans=new ArrayList();
        for(int a:target){
            while(i<a){
                ans.add("Push");
                ans.add("Pop");
                i++;
            }
            ans.add("Push");
            i++;
        }
        return ans;
    }
}