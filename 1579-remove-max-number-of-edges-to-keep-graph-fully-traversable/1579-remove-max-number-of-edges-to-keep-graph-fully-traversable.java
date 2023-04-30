class Solution {
    public int maxNumEdgesToRemove(int n, int[][] edges) {
        DisjointSet A=new DisjointSet(n);
        DisjointSet B=new DisjointSet(n);
        
        Arrays.sort(edges,(a,b)->b[0]-a[0]);
        int count=0;
        
        for(int[] e:edges){
            if(e[0]==3){
                count+=A.union(e[1],e[2]);
                B.union(e[1],e[2]);
            }
            if(e[0]==1){
                count+=A.union(e[1],e[2]);
            }
            else if(e[0]==2)
                count+=B.union(e[1],e[2]);
        }
        if(A.isConnected() && B.isConnected())
            return edges.length-count;
        else
            return -1;
    }
}

class DisjointSet{
    int[] parent;
    int[] size;
    int components;
    
    DisjointSet(int n){
        parent=new int[n+1];
        size=new int[n+1];
        components=n;
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    int findParent(int node){
        if(parent[node]==node)
            return node;
        return parent[node]=findParent(parent[node]);
    }
    
    int union(int node1,int node2){
        int p1=findParent(node1);
        int p2=findParent(node2);
        
        if(p1==p2)
            return 0;
        if(size[p1]>size[p2]){
            parent[p2]=p1;
            size[p1]+=size[p2];
        }
        else{
            size[p2]+=size[p1];
            parent[p1]=p2;
        }
        components--;
        return 1;
    }
    
    boolean isConnected(){
        return components==1;
    }
}