//{ Driver Code Starts
//Initial Template for Java


//Initial Template for Java



import java.io.*;
import java.util.*;


// } Driver Code Ends
//User function Template for Java



class Solution
{
    boolean areConsecutives(long arr[], int N)
    {
        HashMap<Long,Integer>hm=new HashMap<>();
        long min=Integer.MAX_VALUE;
        for(int i=0;i<N;i++)
        {
            if(arr[i]<min)
            min=arr[i];
            hm.put(arr[i],hm.getOrDefault(arr[i],0)+1);
        }
        int i=0;
        while(i<N)
        {
            if(hm.containsKey(min+i))
            i++;
            else
            return false;
        }
        return true;
    }
}


//{ Driver Code Starts.

// Driver class
class Array {

    // Driver code
    public static void main(String[] args) throws IOException {
        // Taking input using buffered reader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testcases = Integer.parseInt(br.readLine());
        // looping through all testcases
        while (testcases-- > 0) {
            int n = Integer.parseInt(br.readLine());
            //int y =Integer.parseInt(a2[2]);
            String line1 = br.readLine();
            String[] a1 = line1.trim().split("\\s+");
            long a[] = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(a1[i]);
            }
            Solution ob = new Solution();
            boolean ans=ob.areConsecutives(a,n);
           // System.out.println(ob.shuffleArray(a,n));
            if(ans)
            System.out.println("Yes");
            else
            System.out.println("No");

        }
    }
}



// } Driver Code Ends