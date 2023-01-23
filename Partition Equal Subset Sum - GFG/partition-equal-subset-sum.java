//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int nums[])
    {
        // code here
        int sum=0;
        for(int i=0;i<nums.length;i++)
            sum+=nums[i];
        if(sum%2!=0)
            return 0;
        if(nums.length<=1)
            return 0;
        int target=sum/2;
        return isSubsetSum(nums.length-1,nums,target)==false?0:1;
    }
    
    public static boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        boolean[][] dp=new boolean[N][sum+1];
        for(int i=0;i<N;i++)
        dp[i][0]=true;
        if(arr[0]<sum)
        dp[0][arr[0]]=true;
        for(int ind=1;ind<N;ind++)
        {
            for(int target=1;target<=sum;target++)
            {
                boolean not_pick=dp[ind-1][target];
                boolean pick=false;
                if(arr[ind]<=target)
                pick=dp[ind-1][target-arr[ind]];
                boolean result=pick || not_pick;
                dp[ind][target]=result;
            }
        }
        return dp[N-1][sum];
    }
}