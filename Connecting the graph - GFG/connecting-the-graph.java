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
            int m = sc.nextInt();
            int[][] edge = new int[m][2];
            for (int i = 0; i < m; i++) {
                edge[i][0] = sc.nextInt();
                edge[i][1] = sc.nextInt();
            }

            Solution obj = new Solution();
            int ans = obj.Solve(n, edge);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {

    public int Solve(int n, int[][] edge) {
        // Code here
        DisjointSet ds=new DisjointSet(n);
        int extra=0,comp=0;
        for(int i=0;i<edge.length;i++){
            int u=edge[i][0];
            int v=edge[i][1];
            if(ds.findUpar(u)==ds.findUpar(v))
            extra++;
            else
            ds.unionBySize(u,v);
        }
        
        for(int i=0;i<n;i++){
            if(ds.parent.get(i)==i)
            comp++;
        }
        
        if(extra>=comp-1)
        return comp-1;
        else
        return -1;
    }
}

class DisjointSet{
    public List<Integer>parent=new ArrayList<>();
    public List<Integer>size=new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    int findUpar(int node){
        if(node==parent.get(node))
        return node;
        int ulp=findUpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    void unionBySize(int u,int v){
        int ulp_u=findUpar(u);
        int ulp_v=findUpar(v);
        
        if(ulp_u==ulp_v)
        return;
        
        if(size.get(ulp_u)<size.get(ulp_v)){
            parent.set(ulp_u,ulp_v);
            size.set(ulp_v,size.get(ulp_u)+size.get(ulp_v));
        }
        else{
            parent.set(ulp_v,ulp_u);
            size.set(ulp_u ,size.get(ulp_u)+size.get(ulp_v));
        }
    }
}