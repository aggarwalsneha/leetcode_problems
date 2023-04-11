//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Gfg
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            // arraylist of arraylist to represent graph
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            
            int V = Integer.parseInt(sc.next());
            int E = Integer.parseInt(sc.next());
            
            for(int i =0; i < V; i++)
                adj.add(i, new ArrayList<Integer>());
                
            for(int i = 1; i <= E; i++)
            {    int u = Integer.parseInt(sc.next());
                 int v = Integer.parseInt(sc.next());
                 
                 // adding directed edgese between 
                 // vertex 'u' and 'v'
                 adj.get(u).add(v);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.kosaraju(V, adj));
		}
    }
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int V, ArrayList<ArrayList<Integer>> adj)
    {
        //code here
        Stack<Integer> st=new Stack<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                dfs1(i,adj,visited,st);
            }
        }
        ArrayList<ArrayList<Integer>> new_adj=new ArrayList<>();
        for(int i=0;i<V;i++){
            new_adj.add(new ArrayList<>());
        }
        for(int i=0;i<V;i++){
            visited[i]=false;
            for(int it:adj.get(i)){
                new_adj.get(it).add(i);
            }
        }
        int cnt=0;
        while(!st.isEmpty()){
            int i=st.pop();
            if(!visited[i]){
                cnt++;
                dfs2(i,new_adj,visited);
            }
        }
        return cnt;
    }
    static void dfs1(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited,Stack<Integer> st){
        visited[node]=true;
        for(int num:adj.get(node)){
            if(!visited[num])
                dfs1(num,adj,visited,st);
        }
        st.push(node);
    }
    static void dfs2(int node,ArrayList<ArrayList<Integer>> adj,boolean[] visited){
        visited[node]=true;
        for(int num:adj.get(node)){
            if(!visited[num])
                dfs2(num,adj,visited);
        }
    } 
}
