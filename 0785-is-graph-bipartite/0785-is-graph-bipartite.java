class Solution {
    public boolean isBipartite(int[][] graph) {
        int V=graph.length;
        Queue<Integer>q=new LinkedList<>();
        int[] visited=new int[V];
        Arrays.fill(visited,-1);
        for(int i=0;i<V;i++){
            if(visited[i]==-1){
                visited[i]=0;
                q.offer(i);
                while(!q.isEmpty()){
                    int curr=q.poll();
                    for(int num:graph[curr]){
                        if(visited[num]==-1){
                            visited[num]=visited[curr]==1?0:1;
                            q.offer(num);
                        }
                        else if(visited[num]==visited[curr])
                            return false;
                    }
                }
            }
        }
        return true;   
    }
}