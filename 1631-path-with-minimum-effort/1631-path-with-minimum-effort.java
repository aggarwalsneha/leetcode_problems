class Solution {
    int[][] dir={{1,0},{-1,0},{0,1},{0,-1}};
    public int minimumEffortPath(int[][] heights) {
        int m=heights.length,n=heights[0].length;
        int[][] dist=new int[m][n];
        for(int[] d:dist)
            Arrays.fill(d,Integer.MAX_VALUE);
        dist[0][0]=0;
        Queue<Pair> q=new PriorityQueue<>((a,b)->a.d-b.d);
        q.offer(new Pair(0,0,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int i=p.i,j=p.j,d=p.d;
            if(d>dist[i][j])
                continue;
            if(i==m-1 && j==n-1)
                return d;
            for(int[] di:dir){
                int r=i+di[0];
                int c=j+di[1];
                if(r<m && r>=0 && c<n && c>=0){
                    int diff=Math.max(d,Math.abs(heights[r][c]-heights[i][j]));
                    if(dist[r][c]>diff){
                        dist[r][c]=diff;
                        q.offer(new Pair(r,c,diff));
                    }
                }
            }
        }
        return -1;
    }
}

class Pair{
    int i,j,d;
    Pair(int i,int j,int d){
        this.i=i;
        this.j=j;
        this.d=d;
    }
}