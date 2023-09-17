class Solution {
    public int shortestPathLength(int[][] graph) {
        int n=graph.length;
        int rows=(int)Math.pow(2,n);
        int cols=n;
        int[][] dist=new int[rows][cols];
        for(int[] d:dist)
            Arrays.fill(d,-1);
        Queue<int[]>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            int lead=i;
            int mask=0|(1<<i);
            q.add(new int[]{mask,lead});
            dist[mask][lead]=0;
        }
        while(!q.isEmpty()){
            int size=q.size();
            for(int i=0;i<size;i++){
                int[] path=q.remove();
                int mask=path[0];
                int lead=path[1];
                if(mask==rows-1)
                    return dist[mask][lead];
                for(int node:graph[lead]){
                    int newlead=node;
                    int newmask=mask|(1<<node);
                    if(dist[newmask][newlead]!=-1)
                        continue;
                    dist[newmask][newlead]=dist[mask][lead]+1;
                    q.add(new int[]{newmask,newlead});
                }
            }
        }
        return -1;
    }
}