class Solution {
    public int maxCoins(int[] piles) {
        int n=piles.length;
        int ans=0,i=0,j=n-1;
        Arrays.sort(piles);
        while(i<j){
            j--;
            i++;
            ans+=piles[j];
            j--;
        }
        return ans;
    }
}

