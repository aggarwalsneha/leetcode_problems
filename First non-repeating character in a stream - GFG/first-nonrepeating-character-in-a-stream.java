//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String A = br.readLine().trim();
            Solution ob = new Solution();
            String ans = ob.FirstNonRepeating(A);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution
{
    public String FirstNonRepeating(String A)
    {
        // code here
        String str="";
        Queue<Character>q=new LinkedList<>();
        int[] freq=new int[26];
        for(int i=0;i<A.length();i++){
            char c=A.charAt(i);
            freq[c-'a']++;
            if(freq[c-'a']==1)
                q.offer(c);
            else if(!q.isEmpty() && freq[c-'a']>1 && q.peek()==c)
                q.poll();
            while(!q.isEmpty() && freq[q.peek()-'a']>1)
                q.poll();
            if(!q.isEmpty())
                str+=q.peek();
            else
                str+='#';
        }
        return str;
    }
}