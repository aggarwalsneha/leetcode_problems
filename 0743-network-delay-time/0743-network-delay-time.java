import java.util.TreeSet;
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        int[] dist=new int[n+1];
        TreeSet<Pair>hs=new TreeSet<>(new Comparator<>(){
            public int compare(Pair a,Pair b){
                if(a.wt==b.wt)
                    return a.node-b.node;
                return a.wt-b.wt;
            }
        });
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
            adj.add(new ArrayList<Pair>());
        for(int[] edge:times)
        {
            adj.get(edge[0]).add(new Pair(edge[1],edge[2]));
        }
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[k]=0;
        hs.add(new Pair(k,0));
        while(!hs.isEmpty())
        {
            Pair sr=hs.pollFirst();
            int node=sr.node;
            int dis=sr.wt;
            for(Pair neigh:adj.get(node)){
                int num=neigh.node;
                int wt=neigh.wt;
                if(dis+wt<dist[num]){
                    dist[num]=dis+wt;
                    hs.add(new Pair(num,dist[num]));
                }
            }
        }
        for(int i=0;i<=n;i++){
            if(dist[i]==Integer.MAX_VALUE)
                dist[i]=-1;
        }
        // System.out.println(dist[4]);
        int max=-1;
        for(int i=1;i<=n;i++){
            if(dist[i]==-1)
                return -1;
            if(i!=k && dist[i]>max)
                max=dist[i];
        }
        return max;
        
    }
}

class Pair{
    int node,wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}