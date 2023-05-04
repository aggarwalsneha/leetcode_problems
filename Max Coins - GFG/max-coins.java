//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.io.*;

class GFG implements Runnable
{
    public static void main(String args[])throws IOException
    {
        new Thread(null, new GFG(), "whatever", 1<<26).start();
    }
    public void run()
    {
        try{
            BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
            PrintWriter out=new PrintWriter(System.out);
            int t=Integer.parseInt(in.readLine());
            while(t-->0){
                int n=Integer.parseInt(in.readLine().trim());
                int a[][]=new int[n][3];
                for(int i=0;i<n;i++){
                    String s[]=in.readLine().trim().split(" ");
                    a[i][0]=Integer.parseInt(s[0]);
                    a[i][1]=Integer.parseInt(s[1]);
                    a[i][2]=Integer.parseInt(s[2]);
                }
                Solution ob=new Solution();
                out.println(ob.maxCoins(n,a));
            }
            out.close();
        }catch(Exception e){
            ;
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    public static int maxCoins(int n,int ranges[][])
    {
        Arrays.sort(ranges,(a,b)->b[2]-a[2]);
        int ans=ranges[0][2];
        for(int i=0;i<n;i++){
            int start=ranges[i][0];
            int end=ranges[i][1];
            int res=ranges[i][2];
            int j=i+1;
            int temp=0;
            while(j<n){
                if(ranges[j][2]+res<ans)
                break;
                if(ranges[j][0]>=end || ranges[j][1]<=start){
                    temp=Math.max(temp,ranges[j][2]);
                }
                j++;
            }
            ans=Math.max(ans,res+temp);
        }
        return ans;
    }
}