/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		//code
		 Scanner sc = new Scanner (System.in);
		 int t=sc.nextInt();
		 while(t-->0)
		 {
		     int N=sc.nextInt();
		     int[]nums=new int[N];
		     for(int i=0;i<N;i++)
		     nums[i]=sc.nextInt();
		     Map<Integer,Integer>hm=new HashMap<>();
		     for(int i: nums){
		         hm.put(i,hm.getOrDefault(i,0)+1);
		     }
		     PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.f==b.f)?a.n-b.n:b.f-a.f);
             for(Map.Entry<Integer,Integer>entry:hm.entrySet()){
                pq.add(new Pair(entry.getKey(),entry.getValue()));
            }
            while(!pq.isEmpty()){
                int el=pq.peek().n;
                int freq=pq.poll().f;
                for(int i=0;i<freq;i++)
                System.out.print(el+" ");
            }
            System.out.println();
		 }
	}
}
class Pair{
    int n,f;
    Pair(int n,int f)
    {
        this.n=n;
        this.f=f;
    }
}