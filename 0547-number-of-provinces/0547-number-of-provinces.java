class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        int m=isConnected[0].length;
        ArrayList<Integer>[] adj=new ArrayList[n];
        for(int i=0;i<n;i++){
            adj[i]=new ArrayList<Integer>();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(isConnected[i][j]==1 && i!=j){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }
        boolean[] visited=new boolean[n];
        int count=0;
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(i,adj,visited);
            }
        }
        return count;
    }
    
    public void dfs(int node,ArrayList<Integer>[] adj,boolean[] visited)
    {
        visited[node]=true;
        for(int num:adj[node])
        {
            if(!visited[num])
                dfs(num,adj,visited);
        }
    }
}