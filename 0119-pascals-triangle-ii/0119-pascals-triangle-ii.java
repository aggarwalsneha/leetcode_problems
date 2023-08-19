class Solution {
    public List<Integer> getRow(int rowIndex) {
        long n=1;
        List<Integer>ans=new ArrayList<>();
        ans.add((int)1);
        for(int i=1;i<=rowIndex;i++){
            n=n*(rowIndex-i+1);
            n/=i;
            ans.add((int)n);
        }
        return ans;
    }
}