//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
        int count=0;
        Pair[] act=new Pair[n];
        for(int i=0;i<n;i++)
        act[i]=new Pair(start[i],end[i]);
        
        Arrays.sort(act,(a,b)->a.end==b.end?a.start-b.start:a.end-b.end);
        count=1;
        int prev=act[0].end;
        for(int i=1;i<n;i++)
        {
            if(act[i].start>prev){
            count++;
            prev=act[i].end;
            }
        }
        return count;
    }
}
class Pair{
    int start,end;
    public Pair(int start,int end)
    {
        this.start=start;
        this.end=end;
    }
}
