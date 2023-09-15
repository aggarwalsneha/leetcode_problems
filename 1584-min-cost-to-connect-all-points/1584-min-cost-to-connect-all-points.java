class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n=points.length,ans=0;
        Queue<int[]>pq=new PriorityQueue<>((a,b)->a[0]-b[0]);
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++)
                pq.add(new int[]{findDist(points,i,j),i,j});
        }
        int count=0;
        UnionFind uf=new UnionFind(n);
        while(count<n-1){
            int[] edge=pq.poll();
            if(uf.find(edge[1])!=uf.find(edge[2])){
                ans+=edge[0];
                count++;
                uf.union(edge[1],edge[2]);
            }
        }
        return ans;
    }
    
    public int findDist(int[][] points,int i,int j){
        return Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
    }
}

class UnionFind {   
        int[] parent;
        UnionFind(int n){
            this.parent=new int[n];
            for(int i=0;i<n;i++)
                parent[i]=i;
        }		
        public void union(int a,int b){
            parent[find(a)]=parent[find(b)];
        }
        public int find(int x){
            if(parent[x]!=x)
                parent[x]=find(parent[x]);
            return parent[x];
        }
    }