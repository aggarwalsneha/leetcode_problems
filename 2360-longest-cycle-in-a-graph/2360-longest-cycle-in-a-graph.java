class Solution {
    public int longestCycle(int[] edges) {
        int n=edges.length;
        boolean[] visited=new boolean[n];
        int[] indegree=new int[n];
        for(int e:edges){
            if(e!=-1) {
                indegree[e]++;
            }
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]== 0){
                q.offer(i);
            }
        }
        while(!q.isEmpty()){
            int curr=q.poll();
            visited[curr]=true;
            int i=edges[curr];
            if(i!=-1){
                indegree[i]--;
                if(indegree[i]==0){
                    q.offer(i);
                }
            }
        }
        int ans=-1;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                int neighbor=edges[i];
                int count=1;
                visited[i]=true;
                while(neighbor!=i) {
                    visited[neighbor]=true;
                    count++;
                    neighbor=edges[neighbor];
                }
                ans=Math.max(ans,count);
             }
        }
        return ans;
    }
}