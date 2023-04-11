class Solution {
    int timer=1;
    
    public void dfs(int node,int parent,List<List<Integer>>adj,boolean[] visited,int[] tin,int[] low, List<List<Integer>>ans){
        visited[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        for(int it:adj.get(node)){
            if(it==parent)
                continue;
            if(!visited[it]){
                dfs(it,node,adj,visited,tin,low,ans);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>tin[node]){
                    List<Integer>temp=new ArrayList<>();
                    temp.add(node);
                    temp.add(it);
                    ans.add(new ArrayList<>(temp));
                }
            }
            else{
                low[node]=Math.min(low[node],low[it]);
            }
        }
    }
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(List<Integer> e:connections){
            adj.get(e.get(0)).add(e.get(1));
            adj.get(e.get(1)).add(e.get(0));
        }
        boolean[] visited=new boolean[n];
        int[] tin=new int[n];
        int[] low=new int[n];
        
        List<List<Integer>>ans=new ArrayList<>();
        dfs(0,-1,adj,visited,tin,low,ans);
        return ans;
    }
}