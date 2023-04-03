//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

// Position this line where user code will be pasted.

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            List<List<Integer>> adj = new ArrayList<>();

            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>());
            }
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();

                adj.get(u).add(v);
            }

            Solution obj = new Solution();
            List<Integer> safeNodes = obj.eventualSafeNodes(V, adj);
            for (int i : safeNodes) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    List<Integer> eventualSafeNodes(int V, List<List<Integer>> adj) {

        // Your code here
        boolean[] visited=new boolean[V];
        boolean[] pathvisited= new boolean[V];
        boolean[] check=new boolean[V];
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<V;i++)
        {
            if(!visited[i])
            dfs(i,adj,visited,pathvisited,check);
        }
        for(int i=0;i<V;i++)
        {
            if(check[i])
            ans.add(i);
        }
        return ans;
    }
    
    public static boolean dfs(int node,List<List<Integer>> adj,boolean[] visited,boolean[] pathvisited,boolean[] check)
    {
        visited[node]=true;
        pathvisited[node]=true;
        for(int num:adj.get(node)){
            if(!visited[num]){
                if(dfs(num,adj,visited,pathvisited,check))
                return true;
            }
            else if(pathvisited[num]){
                return true;
            }
        }
        check[node]=true;
        pathvisited[node]=false;
        return false;
    }
}
