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
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                arr[i][0] = sc.nextInt();
                arr[i][1] = sc.nextInt();
            }
            Solution obj = new Solution();
            int ans = obj.maxRemove(arr, n);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


class Solution {

    int maxRemove(int[][] stones, int n) {
        // Code here
        int maxCol=0,maxRow=0;
        for(int[] e:stones){
            maxRow=Math.max(maxRow,e[0]);
            maxCol=Math.max(maxCol,e[1]);
        }
        DisjointSet ds=new DisjointSet(maxRow+maxCol+1);
        Set<Integer>hs=new HashSet<>();
        for(int[] it:stones){
            int r=it[0];
            int c=it[1]+maxRow+1;
            ds.unionBySize(r,c);
            hs.add(r);
            hs.add(c);
        }
        int count=0;
        for(int el:hs){
            if(ds.findpar(el)==el)
            count++;
        }
        return n-count;
    }
}
class DisjointSet{
    List<Integer>parent=new ArrayList<>();
    List<Integer>size=new ArrayList<>();
    
    DisjointSet(int n){
        for(int i=0;i<=n;i++){
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