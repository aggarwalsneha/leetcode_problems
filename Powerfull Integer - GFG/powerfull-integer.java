//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int t=Integer.parseInt(in.readLine());
        while(t-->0){
            int n=Integer.parseInt(in.readLine().trim());
            int a[][]=new int[n][2];
            for(int i=0;i<n;i++){
                String s[]=in.readLine().trim().split(" ");
                a[i][0]=Integer.parseInt(s[0]);
                a[i][1]=Integer.parseInt(s[1]);
            }
            int k=Integer.parseInt(in.readLine().trim());
            Solution ob=new Solution();
            out.println(ob.powerfullInteger(n,a,k));
        }
        out.close();
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int powerfullInteger(int n,int interval[][],int k)
    {
        int[] start=new int[n];
        int[] end=new int[n];
        for(int i=0;i<n;i++){
            start[i]=interval[i][0];
            end[i]=interval[i][1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        
        int ans=-1,cnt=0,j=0;
        for(int i=0;i<n;i++){
            while(j<n && start[i]>end[j]){
                if(cnt>=k)
                ans=end[j];
                
                j++;
                cnt--;
            }
            cnt++;
        }
        if(cnt>=k)
        ans=end[j+cnt-k];
        
        return ans;
    }
}