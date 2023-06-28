class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
        List<List<Pair<Integer,Double>>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<edges.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double p=succProb[i];
            adj.get(u).add(new Pair<>(v,p));
            adj.get(v).add(new Pair<>(u,p));
        }
        double[] dist=new double[n];
        Arrays.fill(dist,0.0);
        dist[start]=1.0;
        
        Queue<Integer>q=new LinkedList<>();
        q.offer(start);
        while(!q.isEmpty()){
            int curr=q.poll();
            for(Pair<Integer,Double> p:adj.get(curr)){
                int node=p.getKey();
                double prob=p.getValue();
                double new_prob=prob*dist[curr];
                if(new_prob>dist[node]){
                    dist[node]=new_prob;
                    q.offer(node);
                }
            }
        }
        return dist[end];
    }
}