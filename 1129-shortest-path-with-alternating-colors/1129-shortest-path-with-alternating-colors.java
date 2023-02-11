class Pair{
    int node;
    char color;
    int dist;
    Pair(int node,char color,int dist){
        this.node=node;
        this.color=color;
        this.dist=dist;
    }
}

class Solution {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] res=new int[n];
        boolean vis[][]=new boolean[2][n];
        vis[0][0]=true;
        vis[1][0]=true;
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<redEdges.length;i++){
            adj.get(redEdges[i][0]).add(new Pair(redEdges[i][1],'R',1));
        }
        for(int i=0;i<blueEdges.length;i++){
            adj.get(blueEdges[i][0]).add(new Pair(blueEdges[i][1],'B',1));
        }
        Arrays.fill(res,Integer.MAX_VALUE);
        Queue<Pair> qu=new LinkedList<>();
        res[0]=0;
        for(Pair it:adj.get(0)){
            qu.add(new Pair(it.node,it.color,1));
            if(it.color=='R'){
                vis[0][it.node]=true;
            }
            else{
                vis[1][it.node]=true;
            }
        }
        while(!qu.isEmpty()){
            Pair p=qu.poll();
            int node=p.node;
            char color=p.color;
            int dist=p.dist;
            res[node]=Math.min(dist,res[node]);
            for(Pair it:adj.get(node)){
                int currnode=it.node;
                char currcolor=it.color;
                int currdist=it.dist;
                if(color=='R' && currcolor=='B' && !vis[1][currnode]){
                    vis[1][currnode]=true;
                    qu.add(new Pair(currnode,currcolor,dist+currdist));
                }
                else if(color=='B' && currcolor=='R' && !vis[0][currnode]){
                    vis[0][currnode]=true;
                    qu.add(new Pair(currnode,currcolor,dist+currdist));                   
                }
            }
        }
        for(int i=0;i<res.length;i++){
            if(res[i]==Integer.MAX_VALUE)
                res[i]=-1;
        }
       return res; 
    }
}