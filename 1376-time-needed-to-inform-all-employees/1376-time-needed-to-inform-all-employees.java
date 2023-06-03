class Solution {
    int max=Integer.MIN_VALUE;
    
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<Integer>());
        for(int i=0;i<n;i++){
            if(manager[i]!=-1)
                adj.get(manager[i]).add(i);
        }
        dfs(adj,informTime,headID,0);
        return max;
    }
    
    void dfs(List<List<Integer>>adj,int[] informTime,int curr,int t){
        max=Math.max(max,t);
        for(int node:adj.get(curr)){
            dfs(adj,informTime,node,t+informTime[curr]);
        }
    }
}