//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    String inputLine[] = br.readLine().trim().split(" ");
		    int m = Integer.parseInt(inputLine[0]);
		    int n = Integer.parseInt(inputLine[1]);
		    Solution ob = new Solution();
		    System.out.println(ob.numberOfPaths(m, n));
		}
	}
}




// } Driver Code Ends


class Solution{
    long numberOfPaths(int m, int n) {
        // Code Here
        int count=0;
        return solve(m,n,0,0,count);
    }
    
    static int solve(int m,int n,int i,int j,int count)
    {
        if(i==m-1 || j== n-1)
        return count+1;
        if(i>=m || j>=n)
        return 0;
        return solve(m,n,i+1,j,count)+solve(m,n,i,j+1,count);
    }
    
}