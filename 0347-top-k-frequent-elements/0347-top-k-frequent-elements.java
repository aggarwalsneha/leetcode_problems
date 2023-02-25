class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer>hm=new HashMap<>();
        for(int n: nums){
            hm.put(n,hm.getOrDefault(n,0)+1);
        }
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b)->a.f-b.f);
        for(Map.Entry<Integer,Integer>entry:hm.entrySet()){
            pq.add(new Pair(entry.getKey(),entry.getValue()));
            if(pq.size()>k)
                   pq.poll();
        }
        int[] ans=new int[k];
        while(!pq.isEmpty()){
            ans[--k]=pq.poll().n;
        }
        return ans;
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