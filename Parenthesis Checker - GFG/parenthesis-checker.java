//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class Driverclass
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        
        //Reading total number of testcases
        int t= sc.nextInt();
        
        while(t-- >0)
        {
            //reading the string
            String st = sc.next();
            
            //calling ispar method of Paranthesis class 
            //and printing "balanced" if it returns true
            //else printing "not balanced"
            if(new Solution().ispar(st) == true)
                System.out.println("balanced");
            else
                System.out.println("not balanced");
        
        }
    }
}
// } Driver Code Ends



class Solution
{
    //Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // add your code here
        Stack<Character>st=new Stack<>();
        Map<Character,Character>hm=new HashMap<>();
        hm.put('(',')');
        hm.put('{','}');
        hm.put('[',']');
        for(int i=0;i<x.length();i++){
            char c=x.charAt(i);
            if(c=='(' || c=='{' || c=='[')
                st.push(c);
            else if(st.isEmpty())
                return false;
            else{
                if(hm.get(st.peek())==c)
                st.pop();
                else
                return false;
            }
        }
        return st.size()==0;
    }
}
