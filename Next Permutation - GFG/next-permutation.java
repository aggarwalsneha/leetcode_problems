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
            String a[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(a[i]);
            
            Solution ob = new Solution();
            List<Integer> ans = new ArrayList<Integer>();
            ans = ob.nextPermutation(N, arr);
            StringBuilder out = new StringBuilder();
            for(int i = 0;i < N;i++)
                out.append(ans.get(i) + " ");
            System.out.println(out);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution{
    static List<Integer> nextPermutation(int N, int nums[]){
        // code here
        List<Integer>ans=new ArrayList<Integer>();
        if(nums.length<=1){
        for(int i=0;i<N;i++)
        ans.add(nums[i]);
        return ans;
        }
        int i=nums.length-2;
        while(i>=0 && nums[i]>=nums[i+1])
        i--;
        if(i>=0)
        {
            int j=nums.length-1;
            while(nums[j]<=nums[i])
            j--;
            swap(nums,i,j);
        }
        reverse(nums,i+1,nums.length-1);
        for(int k=0;k<N;k++)
        ans.add(nums[k]);
        return ans;
    }
    static void swap(int[]nums,int i,int j)
    {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
    static void reverse(int[] nums,int i,int j)
    {
        while(i<j)
        swap(nums,i++,j--);
    }
}