class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        int[] indegree=new int[n];
        for(int[] e:relations){
            adj.get(e[0]-1).add(e[1]-1);
            indegree[e[1]-1]++;
        }
        Queue<Integer>q=new LinkedList<>();
        int[] maxTime=new int[n];
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
                maxTime[i]=time[i];
            }
        }
        while(!q.isEmpty()){
            int node=q.remove();
            for(int neigh:adj.get(node)){
                maxTime[neigh]=Math.max(maxTime[neigh],maxTime[node]+time[neigh]);
                indegree[neigh]--;
                if(indegree[neigh]==0)
                    q.add(neigh);
            }
        }
        int ans=0;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,maxTime[i]);
        
        return ans;
    }
}