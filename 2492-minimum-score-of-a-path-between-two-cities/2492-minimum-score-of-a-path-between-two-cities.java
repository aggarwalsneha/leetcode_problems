class Solution {
    int ans=Integer.MAX_VALUE;
    public int minScore(int n, int[][] roads) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<>());
        for(int e[]:roads) {
            adj.get(e[0]).add(new int[]{e[1],e[2]});
            adj.get(e[1]).add(new int[]{e[0],e[2]});
        }
        return bfs(adj,n);
    }
    public int bfs(List<List<int[]>> adj,int n){
        boolean vis[]=new boolean[n+1];
        vis[1]=true;
        Queue<Integer>q=new LinkedList<>();
        q.offer(1);
        while(!q.isEmpty()){
            int curr=q.poll();
            vis[curr]=true;
            for(int[] e: adj.get(curr)){
                ans=Math.min(ans,e[1]);
                if(!vis[e[0]])
                   q.offer(e[0]);
            }
        }
        return ans;
    }
}