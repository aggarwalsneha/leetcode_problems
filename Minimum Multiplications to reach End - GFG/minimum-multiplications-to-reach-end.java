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
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int i = 0; i < n; i++) {
                a[i] = sc.nextInt();
            }

            int start = sc.nextInt();
            int end = sc.nextInt();

            Solution ob = new Solution();
            int ans = ob.minimumMultiplications(a, start, end);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int minimumMultiplications(int[] arr, int start, int end) {
        Queue<Pair>q=new PriorityQueue<>((a,b)->a.steps-b.steps);
        int[] dist=new int[100000];
        Arrays.fill(dist,Integer.MAX_VALUE);
        if(start==end)
        return 0;
        dist[start]=0;
        q.offer(new Pair(start,0));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int num=p.num;
            int steps=p.steps;
            for(int i=0;i<arr.length;i++){
                int new_num=(num*arr[i])%100000;
                if(steps+1<dist[new_num]){
                    dist[new_num]=steps+1;
                    if(new_num==end)
                    return steps+1;
                    q.offer(new Pair(new_num,steps+1));
                }
            }
        }
        // Your code here
        return -1;
    }
}

class Pair{
    int num,steps;
    Pair(int num,int steps){
        this.num=num;
        this.steps=steps;
    }
}