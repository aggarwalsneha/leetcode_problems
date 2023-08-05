class Solution {
    public int numTrees(int n) {
        return trees(1,n);
    }
    
    int trees(int low,int high){
        if(low>=high)
            return 1;
        int total=0;
        for(int i=low;i<=high;i++)
            total+=trees(low,i-1)*trees(i+1,high);
        return total;
    }
}