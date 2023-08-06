//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class Main {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		
		int T=sc.nextInt();
		sc.nextLine();
		while(T-->0)
		{
		    
		    Solution ob=new Solution();
		    
		    String S=sc.nextLine();
		    
		    ArrayList<String> arr = ob.permutation(S);
		    for(String s : arr){
		        System.out.print(s+" ");
		    }
		    System.out.println();
		}
		
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution
{
    static ArrayList<String> ans;
    public ArrayList<String> permutation(String S)
    {
        //Your code here
        ans=new ArrayList<>();
        permute(0,S);
        Collections.sort(ans);
        return ans;
    }
    
    void permute(int ind,String s){
        if(ind==s.length()){
            ans.add(s);
            return;
        }
        for(int i=ind;i<s.length();i++){
            s=swap(s,ind,i);
            permute(ind+1,s);
            s=swap(s,ind,i);
        }
    }
    
    String swap(String s,int i,int j){
        char[] arr=s.toCharArray();
        char temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
        
        return String.valueOf(arr);
    }
	   
}
