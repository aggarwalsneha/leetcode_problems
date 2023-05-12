//{ Driver Code Starts
import java.io.*;
import java.util.*;


class IntArray
{
    public static int[] input(BufferedReader br, int n) throws IOException
    {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for(int i = 0; i < n; i++)
            a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a)
    {
        for(int e : a)
            System.out.print(e + " ");
        System.out.println();
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
            
            
            int[] arr = IntArray.input(br, n);
            
            Solution obj = new Solution();
            int res = obj.arrayOperations(n, arr);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static int arrayOperations(int n, int[] arr) {
        // code here
        int nonZero=-1;
		int prevZero=-1;
		int zeroesCount=0;
		int ans=0;

		for(int i=0;i<n;i++){
			if(arr[i]==0){
				zeroesCount++;
				if(nonZero!=-1 && prevZero!=i-1){
					ans++;
				}
				prevZero=i;
			}
			else{
				nonZero=i;
				if(i==n-1)
					ans++;
			}
		}
		if(zeroesCount==0)
			return -1;
		else
			return ans;


    }
}
        
