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
            int[][] grid = new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    grid[i][j]=sc.nextInt();
                }
            }
            
            Solution obj = new Solution();
            int ans = obj.MaxConnection(grid);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    
    public int MaxConnection(int grid[][]) {
        //Your code here
        int n=grid.length;
        boolean[][] visted=new boolean[n][n];
        DisjointSet ds=new DisjointSet(n*n);
        int[] x=new int[]{0,0,1,-1};
        int[] y=new int[]{1,-1,0,0};
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int k=0;k<4;k++){
                        int new_r=i+x[k];
                        int new_c=j+y[k];
                        if(new_r>=0 && new_c>=0 && new_r<n && new_c<n && grid[new_r][new_c]==1){
                            int node=i*n+j;
                            int adj=new_r*n+new_c;
                            ds.unionBySize(node,adj);
                        }
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    Set<Integer> compo=new HashSet<>();
                    for(int k=0;k<4;k++){
                        int new_r=i+x[k];
                        int new_c=j+y[k];
                        if(new_r>=0 && new_c>=0 && new_r<n && new_c<n && grid[new_r][new_c]==1){
                            int adj=new_r*n+new_c;
                            compo.add(ds.findpar(adj));
                        }
                    }
                    int size=0;
                    for(int el:compo){
                    size+=ds.size.get(el);
                    }
                    max=Math.max(max,size+1);
                }
            }
        }
        for(int i=0;i<n*n;i++){
            max=Math.max(max,ds.size.get(ds.findpar(i)));
        }
        return max;
    }
}

class DisjointSet{
    List<Integer>parent=new ArrayList<>();
    List<Integer>size=new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<n;i++){
            parent.add(i);
            size.add(1);
        }
    }
    
    int findpar(int node){
        if(node==parent.get(node))
        return node;
        int ulp=findpar(parent.get(node));
        parent.set(node,ulp);
        return parent.get(node);
    }
    
    void unionBySize(int u,int v){
        int up=findpar(u);
        int vp=findpar(v);
        if(up==vp)
        return;
        if(size.get(up)<size.get(vp)){
            parent.set(up,vp);
            size.set(vp,size.get(up)+size.get(vp));
        }
        else{
            parent.set(vp,up);
            size.set(up,size.get(up)+size.get(vp));
        }
    }
}