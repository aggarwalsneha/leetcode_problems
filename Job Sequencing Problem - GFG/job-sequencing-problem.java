//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class Job {
    int id, profit, deadline;
    Job(int x, int y, int z){
        this.id = x;
        this.deadline = y;
        this.profit = z; 
    }
}

class GfG {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
            String inputLine[] = br.readLine().trim().split(" ");
            
            //size of array
            int n = Integer.parseInt(inputLine[0]);
            Job[] arr = new Job[n];
            inputLine = br.readLine().trim().split(" ");
            
            //adding id, deadline, profit
            for(int i=0, k=0; i<n; i++){
                arr[i] = new Job(Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]), Integer.parseInt(inputLine[k++]));
            }
            
            Solution ob = new Solution();
            
            //function call
            int[] res = ob.JobScheduling(arr, n);
            System.out.println (res[0] + " " + res[1]);
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        // Your code here
        pair[] p=new pair[n];
        for(int i=0;i<n;i++){
            p[i]=new pair(arr[i].deadline,arr[i].profit);
        }
        Arrays.sort(p,(a,b)->a.first-b.first);
        Queue<Integer>q=new PriorityQueue<>();
        int count=0;
        for(int i=0;i<n;i++){
            if(count<p[i].first){
                count++;
                q.offer(p[i].second);
            }
            else{
                if(q.peek()<p[i].second){
                    q.poll();
                    q.offer(p[i].second);
                }
            }
        }
        int sum=0;
        while(!q.isEmpty())
            sum+=q.poll();
        return new int[]{count,sum};
    }
}

class pair{
    int first,second;
    pair(int first,int second){
        this.first=first;
        this.second=second;
    }
}