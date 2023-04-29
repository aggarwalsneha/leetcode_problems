class Solution {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        DisjointSet ds=new DisjointSet(n);
        int m=queries.length;
        boolean[] ans=new boolean[m];
        
        int[][] q=new int[m][4];
        for(int i=0;i<m;i++){
            q[i][0]=queries[i][0];
            q[i][1]=queries[i][1];
            q[i][2]=queries[i][2];
            q[i][3]=i;
        }
        Arrays.sort(edgeList,(a,b)->a[2]-b[2]);
        Arrays.sort(q,(a,b)->a[2]-b[2]);
        
        int k=0;
        for(int i=0;i<m;i++){
            int u=q[i][0];
            int v=q[i][1];
            int limit=q[i][2];
            int ind=q[i][3];
            
            while(k<edgeList.length && limit>edgeList[k][2]){
                int node1=edgeList[k][0];
                int node2=edgeList[k][1];
                ds.union(node1,node2);
                k++;
            }
            ans[ind]=ds.connected(u,v);
        }
        return ans;
    }
}

class DisjointSet{
    public int[] parent;
    public int[] size;
    
    DisjointSet(int n){
        parent=new int[n];
        size=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    public int findParent(int node){
        if(parent[node]!=node){
            parent[node]=findParent(parent[node]);
        }
        return parent[node];
    }
    
    public void union(int node1,int node2) {
        int p1=findParent(node1);
        int p2=findParent(node2);
        if(p1==p2)
            return;
        if(size[p1]>=size[p2]){
            parent[p2]=p1;
            size[p1]+=1;
        } 
        else{
            parent[p1]=p2;
            size[p2]+=1;
        }
    }
    
    public boolean connected(int node1,int node2){
        int p1=findParent(node1);
        int p2=findParent(node2);
        return p1==p2;
    }
}