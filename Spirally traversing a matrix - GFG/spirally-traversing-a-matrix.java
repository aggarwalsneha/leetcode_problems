//{ Driver Code Starts
import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int r = sc.nextInt();
            int c = sc.nextInt();
            
            int matrix[][] = new int[r][c];
            
            for(int i = 0; i < r; i++)
            {
                for(int j = 0; j < c; j++)
                 matrix[i][j] = sc.nextInt();
            }
            Solution ob = new Solution();
            ArrayList<Integer> ans = ob.spirallyTraverse(matrix, r, c);
            for (Integer val: ans) 
                System.out.print(val+" "); 
            System.out.println();
        }
    }
}
// } Driver Code Ends


class Solution
{
    //Function to return a list of integers denoting spiral traversal of matrix.
    static ArrayList<Integer> spirallyTraverse(int matrix[][], int r, int c)
    {
        // code here 
        ArrayList<Integer>ans=new ArrayList<>();
        int min_r=0,min_c=0,max_r=r-1,max_c=c-1;
        int count=r*c;
        while(count>0)
        {
            for(int i=min_c;i<=max_c && count>0;i++)
            {
                ans.add(matrix[min_r][i]);
                count--;
            }
            min_r++;
            for(int i=min_r;i<=max_r && count>0;i++)
            {
                ans.add(matrix[i][max_c]);
                count--;
            }
            max_c--;
            for(int i=max_c;i>=min_c && count>0;i--)
            {
                ans.add(matrix[max_r][i]);
                count--;
            }
            max_r--;
            for(int i=max_r;i>=min_r && count>0;i--)
            {
                ans.add(matrix[i][min_c]);
                count--;
            }
            min_c++;
        }
        return ans;
    }
}
