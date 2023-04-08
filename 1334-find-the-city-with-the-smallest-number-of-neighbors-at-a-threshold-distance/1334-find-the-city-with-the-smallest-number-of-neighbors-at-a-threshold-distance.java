class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        int[][] dist=new int[n][n];
        for(int[] a:dist)
            Arrays.fill(a,Integer.MAX_VALUE);
        for(int[] e:edges){
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            adj.get(e[1]).add(new Pair(e[0],e[2]));
        }
        for(int i=0;i<n;i++)
            dist[i]=dijikstra(i,adj,n);
        
        int city=-1;
        int count=n;
        for(int i=0;i<n;i++){
            int temp=0;
            for(int j=0;j<n;j++){
                if(dist[i][j]<=distanceThreshold)
                    temp++;
            }
            if(temp<=count)
            {
                count=temp;
                city=i;
            }
        }
        return city;
    }
    
    int[] dijikstra(int src,List<List<Pair>> adj,int n){
        Queue<Pair>q=new PriorityQueue<>((a,b)->a.wt-b.wt);
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        q.offer(new Pair(src,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int node=curr.node;
            int dis=curr.wt;
            for(Pair neigh:adj.get(node)){
                int num=neigh.node;
                int wt=neigh.wt;
                if(dis+wt<dist[num]){
                    dist[num]=dis+wt;
                    q.offer(new Pair(num,dist[num]));
                }
            }
        }
        return dist;
    }
}

class Pair{
    int node,wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}