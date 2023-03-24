class Solution {
    public int minReorder(int n, int[][] connections) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++) 
            adj.add(new ArrayList<>());
        for (int[] c : connections) {
            adj.get(c[0]).add(c[1]);
            adj.get(c[1]).add(-c[0]);
        }
        return dfs(adj,new boolean[n],0);
    }
    public int dfs(List<List<Integer>> adj,boolean[] visited, int s)
    {
        int ans=0;
        visited[s]=true;
        for(int i:adj.get(s))
        if(!visited[Math.abs(i)])
            ans+=dfs(adj,visited,Math.abs(i))+(i>0?1:0);
        return ans;   
    }

}