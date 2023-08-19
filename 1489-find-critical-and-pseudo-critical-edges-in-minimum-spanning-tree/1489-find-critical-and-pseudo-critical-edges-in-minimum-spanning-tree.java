class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        List<Integer>c=new ArrayList<>();
        List<Integer>pc=new ArrayList<>();
        Map<int[],Integer>map=new HashMap<>();
        for(int i=0;i<edges.length;i++){
            map.put(edges[i],i);
        }
        Arrays.sort(edges,(e1,e2)->Integer.compare(e1[2],e2[2]));
        int minCost=buildMST(n,edges,null,null);
        for(int i=0;i<edges.length;i++){
            int[] edge=edges[i];
            int index=map.get(edge);
            int costWithout=buildMST(n,edges,null,edge);
            if(costWithout>minCost){
                c.add(index);
            }
            else{
                int costWith=buildMST(n,edges,edge,null);
                if(costWith==minCost)
                    pc.add(index);
            }
        }
        return Arrays.asList(c,pc);
    }
    
    int buildMST(int n,int[][] edges,int[] pick,int[] skip){
        DS ds=new DS(n);
        int cost=0;
        if(pick!=null){
            ds.union(pick[0],pick[1]);
            cost+=pick[2];
        }
        for(int[] edge:edges){
            if(edge!=skip && ds.union(edge[0],edge[1])){
                cost+=edge[2];
            }
        }
        return ds.count==1?cost:Integer.MAX_VALUE;
    }
}

class DS{
    int[] parent;
    int count;
    
    public DS(int n){
        parent=new int[n];
        for(int i=0;i<n;i++)
            parent[i]=i;
        count=n;
    }
    
    public int findParent(int n){
        if(parent[n]==n)
            return n;
        return parent[n]=findParent(parent[n]);
    }
    
    public boolean union(int u,int v){
        int up=findParent(u);
        int vp=findParent(v);
        if(up==vp)
            return false;
        else{
            count--;
            parent[up]=vp;
            return true;
        }
    }
}