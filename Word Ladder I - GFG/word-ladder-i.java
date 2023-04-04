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
            int n = Integer.parseInt(br.readLine().trim());
            String[] wordList = new String[n];
            for(int i = 0; i < n; i++){
                wordList[i] = br.readLine().trim();
            }
            String startWord, targetWord;
            startWord = br.readLine().trim();
            targetWord = br.readLine().trim();
            Solution obj = new Solution();
            int ans = obj.wordLadderLength(startWord, targetWord, wordList);
            System.out.println(ans);
       }
    }
}

// } Driver Code Ends


class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Code here
        Set<String>hs=new HashSet<>();
        for(String str:wordList)
        hs.add(str);
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(startWord,1));
        if(hs.contains(startWord))
            hs.remove(startWord);
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            String w=curr.str;
            int steps=curr.c;
            if(w.equals(targetWord))
                return steps;
            for(int i=0;i<w.length();i++){
                for(char c='a';c<='z';c++){
                    char[] currW=w.toCharArray();
                    currW[i]=c;
                    String new_str=new String(currW);
                    if(hs.contains(new_str)){
                        hs.remove(new_str);
                        q.offer(new Pair(new_str,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}
class Pair{
    String str;
    int c;
    Pair(String str,int c)
    {
        this.str=str;
        this.c=c;
    }
}