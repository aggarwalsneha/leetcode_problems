//{ Driver Code Starts


import java.util.*;
import java.io.*;
import java.lang.*;

public class Main{
	static BufferedReader br;
	static PrintWriter ot;
    public static void main(String args[]) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-- > 0){
			String s[] = br.readLine().trim().split(" ");
			int V = Integer.parseInt(s[0]);
			int E = Integer.parseInt(s[1]);
			int edges[][] = new int[E][3];
			for(int i = 0; i < E; i++){
				s = br.readLine().trim().split(" ");
				edges[i][0] = Integer.parseInt(s[0]);
				edges[i][1] = Integer.parseInt(s[1]);
				edges[i][2] = Integer.parseInt(s[2]);
			}
			ot.println(new Solution().spanningTree(V, E, edges));
		}
		ot.close();
	}
}
// } Driver Code Ends


// User function Template for Java

class Solution{
	static int spanningTree(int V, int E, int edges[][]){
	    // Code Here. 
	    PriorityQueue<Pair>q=new PriorityQueue<>((a,b)->a.wt-b.wt);
	    boolean[] visited=new boolean[V];
	    List<List<Pair>>adj=new ArrayList<>();
	    for(int i=0;i<V;i++){
	        adj.add(new ArrayList<>());
	    }
	    for(int[]e:edges){
	        adj.get(e[0]).add(new Pair(e[1],e[2]));
	        adj.get(e[1]).add(new Pair(e[0],e[2]));
	    }
	    q.offer(new Pair(0,0));
	    int sum=0;
	    while(!q.isEmpty()){
	        Pair curr=q.poll();
	        int node=curr.node;
	        int wt=curr.wt;
	        if(visited[node])
	        continue;
	        visited[node]=true;
	        sum+=wt;
	        for(Pair neigh:adj.get(node)){
	            int num=neigh.node;
	            int w=neigh.wt;
	            q.offer(new Pair(num,w));
	        }
	    }
	    return sum;
	}
}

class Pair{
    int node,wt;
    Pair(int node,int wt){
        this.node=node;
        this.wt=wt;
    }
}