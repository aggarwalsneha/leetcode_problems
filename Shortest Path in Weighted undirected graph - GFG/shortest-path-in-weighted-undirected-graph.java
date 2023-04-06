//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
@SuppressWarnings("unchecked") class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            int edges[][] = new int[m][3];
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
                edges[i][2] = sc.nextInt();
            }
            Solution obj = new Solution();
            List<Integer> ans = obj.shortestPath(n, m, edges);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static List<Integer> shortestPath(int n, int m, int edges[][]) {
        // code here
        List<List<Pair>>adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        adj.add(new ArrayList<>());
        for(int[]e:edges)
        {
            adj.get(e[0]).add(new Pair(e[1],e[2]));
            adj.get(e[1]).add(new Pair(e[0],e[2]));
        }
        List<Integer>ans=new ArrayList<>();
        int[] dist=new int[n+1];
        int[] parent=new int[n+1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        for(int i=0;i<=n;i++)
        parent[i]=i;
        Queue<Pair>q=new PriorityQueue<Pair>((a,b)->a.wt-b.wt);
        
        int src=1;
        dist[src]=0;
        q.offer(new Pair(src,0));
        while(!q.isEmpty()){
            Pair curr=q.poll();
            int node=curr.node;
            int dis=curr.wt;
            for(Pair neigh:adj.get(node)){
                int num=neigh.node;
                int wt=neigh.wt;
                if(dis+wt<dist[num]){
                    dist[num]=dis+wt;
                    parent[num]=node;
                    q.offer(new Pair(num,dist[num]));
                }
            }
        }
        if(dist[n]==Integer.MAX_VALUE)
        {
            ans.add(-1);
            return ans;
        }
        int s=n;
        while(parent[s]!=s)
        {
            ans.add(s);
            s=parent[s];
        }
        ans.add(src);
        Collections.reverse(ans);
        return ans;
    }
}

class Pair{
    int node,wt;
    Pair(int node,int wt)
    {
        this.node=node;
        this.wt=wt;
    }
}