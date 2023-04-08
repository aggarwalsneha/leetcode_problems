class Solution {
    public int countPaths(int n, int[][] roads) {
        int MOD=1000000007;
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:roads){
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            adj.get(e[1]).add(new Pair(e[0],e[2]));
        }
        int[] ways=new int[n];
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        ways[0]=1;
        dist[0]=0;
        Queue<Pair>q=new PriorityQueue<>((a,b)->a.time-b.time);
        q.offer(new Pair(0,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int dis=curr.time;
            int node=curr.node;
            for(Pair neigh:adj.get(node)){
                int num=neigh.node;
                int t=neigh.time;
                if(dis+t<dist[num]){
                    dist[num]=dis+t;
                    ways[num]=ways[node]%MOD;
                    q.offer(new Pair(num,dist[num]));
                }
                else if(dis+t==dist[num]){
                    ways[num]=(ways[num]+ways[node])%MOD;
                }
            }
        }
        return ways[n-1]%MOD;
    }
}

class Pair{
    int node,time;
    Pair(int node,int time){
        this.node=node;
        this.time=time;
    }
}