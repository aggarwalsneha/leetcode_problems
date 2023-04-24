//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int v = sc.nextInt();
                    int m = sc.nextInt();
                    int coins[] = new int[m];
                    for(int i = 0;i<m;i++)
                        coins[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minCoins(coins, m, v));
                }
        }
}    
// } Driver Code Ends


class Solution{
    static int max=1000000000;
	public int minCoins(int coins[], int M, int V) 
	{ 
	    // Your code goes here
	    int[][] dp=new int[M][V+1];
	    for(int[]a:dp)
	        Arrays.fill(a,-1);
	    int ans=solve(M-1,V,coins,dp);
        if(ans!=max)
        return ans;
        else
        return -1;
	} 
	
	static int solve(int ind,int target,int[] coins,int[][]dp){
	    if(ind==0){
	        if(target%coins[ind]==0)
	            return target/coins[0];
	        return max;
	    }
	    if(dp[ind][target]!=-1)
	    return dp[ind][target];
	    int not_take=solve(ind-1,target,coins,dp);
	    int take=Integer.MAX_VALUE;
	    if(coins[ind]<=target)
	    take=1+solve(ind,target-coins[ind],coins,dp);
	    
	    return dp[ind][target]=Math.min(not_take,take);
	}
	
}