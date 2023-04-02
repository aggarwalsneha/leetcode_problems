class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int n=spells.length;
        int m=potions.length;
        int[] ans=new int[n];
        for(int i=0;i<n;i++)
        {
            double target=success/(spells[i]*1.0);
            int ind=-1;
            int l=0,h=m-1;
            int mid=(l+h)/2;
            while(l<=h)
            {
                mid=(l+h)/2;
                if(potions[mid]>=target)
                {
                    ind=mid;
                    h=mid-1;
                }
                else if(potions[mid]<target)
                    l=mid+1;
            }
            if(ind!=-1)
            {
                ans[i]=m-ind;
            }
        }
        return ans;
    }
}