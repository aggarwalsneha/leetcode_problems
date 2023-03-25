class Solution {
    public long countPairs(int n, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        boolean vis[]=new boolean[n];
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        long sum=n;
        long pair=0;
        for(int i=0;i<n;i++)
        {
            if(!vis[i]){
                vis[i]=true;
                int count=bfs(i,vis,adj,0);
                sum-=count;
                pair+=(sum*count);
            }
        }
        return pair;
    }    
    public int bfs(int i,boolean[] vis,List<List<Integer>> adj,int count){
        Queue<Integer>q=new LinkedList<>();
        q.add(i);
        count++;
        while(!q.isEmpty()){
            int curr=q.poll();
            for(int adjnode:adj.get(curr)){
                if(!vis[adjnode]){
                    q.add(adjnode);
                    count++;
                    vis[adjnode]=true;
                }
            }
        }
        return count;
    }
}