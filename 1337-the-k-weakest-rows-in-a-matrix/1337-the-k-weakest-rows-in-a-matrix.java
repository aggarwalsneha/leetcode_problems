class Solution {
    public int[] kWeakestRows(int[][] mat, int k) {
        int[] count=new int[mat.length];
        int[] ans=new int[k];
        for(int i=0;i<mat.length;i++)
        {
            int sol=0;
            for(int j=0;j<mat[i].length;j++)
            {
                if(mat[i][j]==1)
                    sol++;
                else
                    break;
            }
            count[i]=sol*1000+i;
        }
        Arrays.sort(count);
        for(int i=0;i<k;i++)
            ans[i]=count[i]%1000;
        return ans;
    }
}