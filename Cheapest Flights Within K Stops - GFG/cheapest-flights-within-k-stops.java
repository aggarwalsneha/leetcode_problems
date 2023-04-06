//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            int edge=sc.nextInt();
            int[][] adj = new int[edge][3];
            for(int i=0;i<edge;i++){
                adj[i][0]=sc.nextInt();
                adj[i][1]=sc.nextInt();
                adj[i][2]=sc.nextInt();
            }
            int src=sc.nextInt();
            int dst=sc.nextInt();
            int k=sc.nextInt();
            Solution obj = new Solution();
            int res = obj.CheapestFLight(n,adj,src,dst,k);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int CheapestFLight(int n,int flights[][],int src,int dst,int k) {
        // Code here
        ArrayList<ArrayList<Pair>>adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        adj.add(new ArrayList<>());
        for(int[] e:flights)
        adj.get(e[0]).add(new Pair(e[1],e[2]));
        Queue<Tuple>q=new LinkedList<>();
        q.offer(new Tuple(src,0,0));
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        while(!q.isEmpty()){
            Tuple t=q.poll();
            int node=t.node;
            int price=t.price;
            int stops=t.stops;
            if(stops>k)
            continue;
            for(Pair iter:adj.get(node)){
                int adjn=iter.first;
                int cost=iter.second;
                if(cost+price<dist[adjn] && stops<=k)
                {
                    dist[adjn]=cost+price;
                    q.offer(new Tuple(adjn,dist[adjn],stops+1));
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)
        return -1;
        else
        return dist[dst];
    }
}

class Tuple{
    int node,price,stops;
    Tuple(int node,int price,int stops){
        this.node=node;
        this.price=price;
        this.stops=stops;
    }
}

class Pair{
    int first,second;
    Pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}