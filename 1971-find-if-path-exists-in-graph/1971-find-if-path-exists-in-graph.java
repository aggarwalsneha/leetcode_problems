class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited = new boolean[n];
        HashSet<Integer>[] graph = new HashSet[n];
        for(int i = 0; i < n; i++){
            graph[i] = new HashSet<Integer>();
        }
        for(int[] edge : edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        if(graph[source].contains(destination)){ 
            return true;
        }
        Queue<Integer> queue = new LinkedList<Integer>();
        queue.offer(source);
        visited[source] = true;
        while(!queue.isEmpty()){
            int N = queue.size();
            int current = queue.poll();
            if(current == destination){
                    return true;
            }
            for(Integer neighbor : graph[current]){
                if(!visited[neighbor]){
                    visited[neighbor] = true;
                    queue.offer(neighbor);
                }
            }
        }
       
        return false;
    }
}