//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        int t = Integer.parseInt(sc.next());
        while(t>0)
        {
            int n = Integer.parseInt(sc.next());
            Solution T = new Solution();
            List<String> ans = T.AllParenthesis(n);
            String[] sequences = ans.toArray(new String[0]);
            Arrays.sort(sequences);
            int k = sequences.length;
            for(int i=0;i<k;i++)
            {
                System.out.println(sequences[i]);
            }
            
            t--;
            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    static List<String>ans;
    public List<String> AllParenthesis(int n) 
    {
        // Write your code here
        ans=new ArrayList<>();
        int open=n,close=n;
        String curr="";
        solve(open,close,curr);
        return ans;
    }
    public static void solve(int open,int close,String curr)
    {
        if(open==0 && close==0)
        {
            ans.add(curr);
            return;
        }
        if(open>0)
        {
            solve(open-1,close,curr+'(');
        }
        if(close>open)
        {
            solve(open,close-1,curr+')');
        }
    }
    
}