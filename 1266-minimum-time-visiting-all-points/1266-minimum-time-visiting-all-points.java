class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int ans=0;
        for(int i=0;i<points.length-1;i++){
            int x=points[i][0];
            int y=points[i][1];
            int x1=points[i+1][0];
            int y1=points[i+1][1];
            ans+=Math.max(Math.abs(x1-x),Math.abs(y1-y));
        }
        return ans;
    }
}