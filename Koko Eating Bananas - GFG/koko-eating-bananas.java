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
            int a[] = new int[n];
            for(int i=0;i<n;i++){
                a[i]=sc.nextInt();
            }
            int h = sc.nextInt();
            Solution obj = new Solution();
            int ans = obj.Solve(n,a,h);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int Solve(int N, int[] piles, int H) {
        // code here
        int max=0;
        for(int val:piles)
        max=Math.max(max,val);
        int l=0,h=max,ans=0;
        while(l<=h)
        {
            int mid=(l+h)/2;
            if(isPossible(piles,mid,H))
            {
                ans=mid;
                h=mid-1;
            }
            else
            l=mid+1;
        }
        return ans;
    }
    
    public static boolean isPossible(int[]piles,int sp,int h)
    {
        int time=0;
        for(int i=0;i<piles.length;i++)
        time+=(int)Math.ceil(piles[i]*1.0/sp);
        
        return time<=h;
    }
}
        
