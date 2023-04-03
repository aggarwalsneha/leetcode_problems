//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] edge = new int[m][3];
			for (int i = 0; i < m; i++) {
				edge[i][0] = sc.nextInt();
				edge[i][1] = sc.nextInt();
				edge[i][2] = sc.nextInt();
			}
			Solution obj = new Solution();
			int res[] = obj.shortestPath(n, m,edge);
			for (int i = 0; i < n; i++) {
				System.out.print(res[i] + " ");
			}
			System.out.println();
		}
	}
}
// } Driver Code Ends


//User function Template for Java
class Solution {

	public int[] shortestPath(int N,int M, int[][] edges) {
		//Code here
		ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
		for(int i=0;i<N;i++){
		adj.add(new ArrayList<Pair>());
		}
		for(int[] e:edges)
		{
		    adj.get(e[0]).add(new Pair(e[1],e[2]));
		}
		boolean[] visited=new boolean[N];
		Stack<Integer>st=new Stack<>();
		for(int i=0;i<N;i++){
		    if(!visited[i])
		    dfs(i,st,visited,adj);
		}
		int[] dist=new int[N];
		Arrays.fill(dist,Integer.MAX_VALUE);
		dist[0]=0;
		for(int i=0;i<N;i++)
		{
		    if(st.peek()!=0)
		    {
		        dist[st.pop()]=-1;
		    }
		    else
		    break;
		}
		while(!st.isEmpty()){
		    int node=st.pop();
		    for(Pair p:adj.get(node))
		    {
		        int num=p.node;
		        int wt=p.w;
		        if(dist[node]+wt<dist[num]){
		            dist[num]=dist[node]+wt;
		        }
		    }
		}
		for(int i=0;i<N;i++)
		{
		    if(dist[i]==Integer.MAX_VALUE)
		    dist[i]=-1;
		}
		return dist;
	}
	
	static void dfs(int node,Stack<Integer>st,boolean[] visited,ArrayList<ArrayList<Pair>> adj)
	{
	    visited[node]=true;
	    for(Pair p:adj.get(node))
	    {
	        int num=p.node;
	        if(!visited[num])
	        dfs(num,st,visited,adj);
	    }
	    st.push(node);
	}
}

class Pair{
    int node,w;
    Pair(int node,int w)
    {
        this.node=node;
        this.w=w;
    }
}