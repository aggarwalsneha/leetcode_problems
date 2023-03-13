class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.el-b.el);
        int ans=-1;
        int m=matrix.length,n=matrix[0].length;
        for(int i=0;i<Math.min(m,k);i++)
        {
            pq.add(new Pair(matrix[i][0],i,0));
        }
        for(int i=0;i<k;i++)
        {
            Pair curr=pq.poll();
            ans=curr.el;
            if(curr.s+1<n)
                pq.add(new Pair(matrix[curr.f][curr.s+1],curr.f,curr.s+1));
        }
        return ans;
    }
}

class Pair{
    int el,f,s;
    Pair(int el,int f,int s)
    {
        this.el=el;
        this.f=f;
        this.s=s;
    }
}