//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader in=new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out=new PrintWriter(System.out);
        int test = Integer.parseInt(in.readLine().trim());
        while(test-- > 0){
            int n = Integer.parseInt(in.readLine().trim());
            int m = Integer.parseInt(in.readLine().trim());
            String s[]=in.readLine().trim().split(" ");
            int [] seats = new int[m];
            for(int i = 0; i < m; i++){
                seats[i] = Integer.parseInt(s[i]);
            }
            Solution obj = new Solution();
            boolean res = obj.is_possible_to_get_seats(n, m, seats);
            
            String _result_val = (res) ? "Yes" : "No";
            out.println(_result_val);
        }
        out.close();
    }
}

// } Driver Code Ends


class Solution {
    public static boolean is_possible_to_get_seats(int n, int m, int[] seats) {
        // code here
        if(n==0)
        return true;
        if(n>m)
        return false;
        if(n==1 && m==1)
        return seats[0]==0;
        int count=0;
        for(int i=0;i<m-1;i++){
            if(i==0 && seats[i]==0 && seats[i+1]==0){
            count++;
            seats[i]=1;
            }
            else if(i!=0 && seats[i]==0 && seats[i-1]==0 && seats[i+1]==0){
            count++;
            seats[i]=1;
            }
        }
        if(m>1 && seats[m-1]==0 && seats[m-2]==0)
        count++;
        return count>=n;
    }
}
        
