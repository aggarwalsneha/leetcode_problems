//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) adj.add(i, new ArrayList<Integer>());
            for (int i = 0; i < E; i++) {
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isCycle(V, adj);
            if (ans)
                System.out.println("1");
            else
                System.out.println("0");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                if(bfs(i,visited,adj))
                return true;
            }
        }
        return false;
    }
    
    public static boolean bfs(int src,boolean[]visited,ArrayList<ArrayList<Integer>> adj)
    {
        visited[src]=true;
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(src,-1));
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            int node=curr.node;
            int parent=curr.parent;
            for(int num:adj.get(node))
            {
                if(!visited[num]){
                    visited[num]=true;
                    q.offer(new Pair(num,node));
                }
                else if(num!=parent)
                    return true;
            }
        }
        return false;
    }
}

class Pair{
    int node,parent;
    Pair(int node,int parent)
    {
        this.node=node;
        this.parent=parent;
    }
}