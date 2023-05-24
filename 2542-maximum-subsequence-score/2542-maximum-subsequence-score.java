class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n=nums1.length;
        int[][] pairs=new int[n][2];
        for(int i=0;i<n;i++)
            pairs[i]=new int[]{nums1[i],nums2[i]};
        Arrays.sort(pairs,(a, b)->b[1]-a[1]);
        PriorityQueue<Integer> pq=new PriorityQueue<>(k);
        long res=0,sum=0;
        for(int[] p:pairs){
            pq.add(p[0]);
            sum+=p[0];
            if(pq.size()>k)
                sum-=pq.poll();
            if(pq.size()==k)
                res=Math.max(res,(sum*p[1]));
        }
        return res;
    }
}