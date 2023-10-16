//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];

        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }

        return mat;
    }

    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }

    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int n;
            n = Integer.parseInt(br.readLine());
            
            
            int[][] grid = IntMatrix.input(br, n, n);
            
            Solution obj = new Solution();
            int res = obj.largestIsland(n, grid);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution{
    int[][] dir={{-1,0},{1,0},{0,-1},{0,1}};
    public int largestIsland(int n,int[][] grid) 
    {
        // code here
        DisjointSet ds=new DisjointSet(n*n);
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    for(int[] d:dir){
                        int r=i+d[0];
                        int c=j+d[1];
                        if(r>=0 && c>=0 && r<n && c<n && grid[r][c]==1){
                            int node=i*n+j;
                            int adj=r*n+c;
                            ds.unionBySize(node,adj);
                        }
                    }
                }
            }
        }
        int max=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                Set<Integer> comp=new HashSet<>();
                if(grid[i][j]==0){
                    for(int[] d:dir){
                        int r=i+d[0];
                        int c=j+d[1];
                        if(r>=0 && c>=0 && r<n && c<n && grid[r][c]==1){
                            comp.add(ds.findParent(r*n+c));
                        }
                    }
                }
                int s=0;
                for(int it:comp)
                s+=ds.size[it];
                
                max=Math.max(max,s+1);
            }
        }
        for(int i=0;i<n*n;i++){
            max=Math.max(max,ds.size[ds.findParent(i)]);
        }
        return max;
    }
}

class DisjointSet{
    int n;
    int[] parent;
    int[] size;
    DisjointSet(int n){
        this.n=n;
        parent=new int[n+1];
        size=new int[n+1];
        for(int i=0;i<=n;i++){
            parent[i]=i;
            size[i]=1;
        }
    }
    
    int findParent(int node){
        if(parent[node]==node)
        return node;
        return parent[node]=findParent(parent[node]);
    }
    
    void unionBySize(int u,int v){
        int ulp=findParent(u);
        int vlp=findParent(v);
        if(ulp==vlp)
        return;
        if(size[ulp]<size[vlp]){
            parent[ulp]=vlp;
            size[vlp]+=size[ulp];
        }
        else{
            parent[vlp]=ulp;
            size[ulp]+=size[vlp];
        }
    }
}
