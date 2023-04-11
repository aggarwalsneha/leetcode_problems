//{ Driver Code Starts
// Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String[] s = br.readLine().trim().split(" ");
            int V = Integer.parseInt(s[0]);
            int E = Integer.parseInt(s[1]);
            ArrayList<ArrayList<Integer>>adj = new ArrayList<>();
            for(int i = 0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
            for(int i = 0; i < E; i++){
                String[] S = br.readLine().trim().split(" ");
                int u = Integer.parseInt(S[0]);
                int v = Integer.parseInt(S[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            ArrayList<Integer>ans = obj.articulationPoints(V, adj);
            for (int i =0 ;i < ans.size (); i++) 
                System.out.print (ans.get (i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution
{
    //Function to return Breadth First Traversal of given graph.
    static int timer=1;
    public ArrayList<Integer> articulationPoints(int V,ArrayList<ArrayList<Integer>> adj)
    {
        // Code here
        boolean[] visited=new boolean[V];
        int[] tin=new int[V];
        int[] low=new int[V];
        boolean[] marked=new boolean[V];
        ArrayList<Integer>ans=new ArrayList<>();
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs(i,-1,visited,tin,low,marked,adj);
            }
        }
        for(int i=0;i<V;i++){
            if(marked[i]){
                ans.add(i);
            }
        }
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
    public static void dfs(int node,int parent,boolean[] visited,int[] tin,int[] low,
    boolean[] marked,ArrayList<ArrayList<Integer>> adj){
        visited[node]=true;
        tin[node]=low[node]=timer;
        timer++;
        int child=0;
        for(int it:adj.get(node)){
            if(it==parent)
                continue;
            if(!visited[it]){
                dfs(it,node,visited,tin,low,marked,adj);
                low[node]=Math.min(low[node],low[it]);
                if(low[it]>=tin[node] && parent!=-1){
                    marked[node]=true;
                }
                child++;
            }
            else{
                low[node]=Math.min(low[node],tin[it]);
            }
        }
        if(child>1 && parent==-1)
        marked[node]=true;
    }
}