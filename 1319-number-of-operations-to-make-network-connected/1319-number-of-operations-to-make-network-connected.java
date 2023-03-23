class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length<n-1)
            return -1;
        List<Integer>[] adj=new List[n];
        for(int i=0;i<n;i++)
            adj[i]=new ArrayList<>();
        for(int[] edge : connections) {
            adj[edge[0]].add(edge[1]);
            adj[edge[1]].add(edge[0]);
        }
        int ans=0;
        boolean[] visited=new boolean[n];
        for(int v=0;v<n;v++)
            ans+= dfs(v,adj,visited);
        return ans-1; 
    }
    public int dfs(int u,List<Integer>[]adj,boolean[] visited){
        if(visited[u])
            return 0;
        visited[u]=true;
        for(int v:adj[u])
            dfs(v,adj,visited);
        return 1;
    }
}