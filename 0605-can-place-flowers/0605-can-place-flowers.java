class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int count=0;
        for(int i=0;i<flowerbed.length;i++)
        {
            if(flowerbed[i]==0)
            {
                boolean left=false,right=false;
                if(i==0 || flowerbed[i-1]==0)
                    left=true;
                if(i==flowerbed.length-1 || flowerbed[i+1]==0)
                    right=true;
                if(left && right)
                {
                    flowerbed[i]=1;
                    count++;
                }
            }
        }
        return count>=n;
    }
}