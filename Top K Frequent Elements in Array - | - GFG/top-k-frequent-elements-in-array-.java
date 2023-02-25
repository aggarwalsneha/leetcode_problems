//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] s = br.readLine().trim().split(" ");
            int n = Integer.parseInt(s[0]);
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = Integer.parseInt(s[i + 1]);
            }
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            int[] ans = obj.topK(nums, k);
            for (int i = 0; i < ans.length; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public int[] topK(int[] nums, int k) {
        // Code here
        Map<Integer,Integer>hm=new HashMap<>();
        for(int n: nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.f!=b.f)?a.f-b.f:a.n-b.n);
        for(Map.Entry<Integer,Integer>entry:hm.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k)
                   pq.poll();
        }
        int[] ans=new int[k];
        while(!pq.isEmpty()){
            ans[--k]=pq.poll().n;
        }
        return ans;
    }
}
class Pair{
    int n,f;
    Pair(int n,int f)
    {
        this.n=n;
        this.f=f;
    }
}