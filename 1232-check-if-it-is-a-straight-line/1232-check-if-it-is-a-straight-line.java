class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        int dy=getYdiff(coordinates[1],coordinates[0]);
        int dx=getXdiff(coordinates[1],coordinates[0]);
        
        for(int i=2;i<coordinates.length;i++){
            if(dy*getXdiff(coordinates[i],coordinates[0])!=dx*getYdiff(coordinates[i],coordinates[0]))
                return false;
        }
        return true;
    }
    
    int getXdiff(int[] a,int[] b){
        return a[0]-b[0];
    }
    int getYdiff(int[] a,int[] b){
        return a[1]-b[1];
    }
}