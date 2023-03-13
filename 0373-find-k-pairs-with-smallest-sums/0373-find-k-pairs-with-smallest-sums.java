class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>>ans=new ArrayList<>();
        int n1=nums1.length,n2=nums2.length;
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->(a.f+a.s)-(b.f+b.s));
        for(int i=0;i<n1 && i<k;i++)
        {
            pq.add(new Pair(nums1[i],nums2[0],0));
        }
        while(k-->0 && !pq.isEmpty())
        {
            Pair curr=pq.poll();
            ans.add(new ArrayList<>(Arrays.asList(curr.f,curr.s)));
            if(curr.idx==n2-1)
                continue;
            pq.add(new Pair(curr.f,nums2[curr.idx+1],curr.idx+1));
        }
        return ans;
    }
}

class Pair{
    int f,s,idx;
    Pair(int f,int s,int idx)
    {
        this.f=f;
        this.s=s;
        this.idx=idx;
    }
}