class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b)->a[1]-b[1]);
        int curr=Integer.MIN_VALUE;
        int ans=0;
        for(int[] p:pairs){
            if(p[0]>curr){
                ans++;
                curr=p[1];
            }
        }
        return ans;
    }
}