class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n=edges.length;
        int ans=-1;
        int dist=Integer.MAX_VALUE;
        int[] A=new int[n];
        int[] B=new int[n];
        Arrays.fill(A,Integer.MAX_VALUE);
        Arrays.fill(B,Integer.MAX_VALUE);
        
        bfs(edges,A,node1);
        bfs(edges,B,node2);
        
        for(int i=0;i<n;i++)
        {
            if(A[i]==Integer.MAX_VALUE || B[i]==Integer.MAX_VALUE)
                continue;
            if(dist>Math.max(A[i],B[i]))
            {
                ans=i;
                dist=Math.max(A[i],B[i]);
            }
        }
        return ans;
    }
    
    void bfs(int[] edges,int[] dist,int src)
    {
        Queue<Integer>q=new LinkedList<>();
        q.add(src);
        dist[src]=0;
        while(!q.isEmpty())
        {
            int p=q.poll();
            if(edges[p]!=-1 && dist[edges[p]]==Integer.MAX_VALUE)
            {
                q.add(edges[p]);
                dist[edges[p]]=dist[p]+1;
            }
        }
    }
}