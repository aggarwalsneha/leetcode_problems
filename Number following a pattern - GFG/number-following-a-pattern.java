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
            System.out.println(ob.printMinNumberForPattern(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int n=S.length();
        if(n>8 || n==0)
        return "-1";
        Stack<Integer> st=new Stack<>();
        int curr=1;
        String num="";
        for(char ch:S.toCharArray()){
            st.push(curr++);
            if(ch=='I'){
                while(!st.isEmpty()){
                    num+=st.pop();
                }
            }
        }
        st.push(curr);
        while(!st.isEmpty())
        num+=st.pop();
        
        return num;
    }
}
