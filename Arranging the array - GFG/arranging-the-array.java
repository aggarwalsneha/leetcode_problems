//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();
            obj.Rearrange(a, n);
            
            StringBuilder output = new StringBuilder();
            for(int i=0;i<n;i++)
                output.append(a[i]+" ");
            System.out.println(output);
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public void Rearrange(int a[], int n)
    {
        // Your code goes here
        arrange(a,0,n-1);
    }
    static void arrange(int[] arr,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;
        arrange(arr,start,mid);
        arrange(arr,mid+1,end);
        move(arr,start,end,mid);
    }
    
    static void move(int[] arr,int start,int end,int mid){
        int i,j,k;
        int n1=mid-start+1;
        int n2=end-mid;
        int[] l=new int[n1];
        int[] r=new int[n2];
        
        for(i=0;i<n1;i++)
        l[i]=arr[start+i];
        for(j=0;j<n2;j++)
        r[j]=arr[mid+j+1];
        
        i=0;j=0;k=start;
        while(i<n1 && l[i]<0){
            arr[k++]=l[i++];
        }
        while(j<n2 && r[j]<0){
            arr[k++]=r[j++];
        }
        while(i<n1){
            arr[k++]=l[i++];
        }
        while(j<n2){
            arr[k++]=r[j++];
        }
    }
}