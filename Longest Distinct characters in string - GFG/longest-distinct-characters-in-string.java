//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubstrDistinctChars(S));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubstrDistinctChars(String S){
        // code here
        HashMap<Character,Integer> hm=new HashMap<>();
        int l=0;
        int r=0;
        int len=0;
        int n=S.length();
        while(r<n)
        {
            if(hm.containsKey(S.charAt(r)))
                l=Math.max(hm.get(S.charAt(r))+1,l);
            hm.put(S.charAt(r),r);
            len=Math.max(len,r-l+1);
            r+=1;
        }
        return len;
        
    }
}