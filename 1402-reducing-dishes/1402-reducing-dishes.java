class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int suffix=0,max=0;
        int n=satisfaction.length;
        for(int i=n-1;i>=0 && suffix+satisfaction[i]>0;i--)
        {
            suffix+=satisfaction[i];
            max+=suffix;
        }
        return max;
    }
}