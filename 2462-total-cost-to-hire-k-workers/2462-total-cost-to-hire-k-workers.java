class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        PriorityQueue<Integer> pq1=new PriorityQueue<>();
        PriorityQueue<Integer> pq2=new PriorityQueue<>();
        for(int i=0;i<candidates;i++){
            pq1.add(costs[i]);
        }
        for(int i=Math.max(candidates,costs.length-candidates);i<costs.length;i++){
            pq2.add(costs[i]);
        }

        long ans=0;
        int next1=candidates;
        int next2=costs.length-1-candidates;
        for(int i=0;i<k;i++){
            if(pq2.isEmpty() || !pq1.isEmpty() && pq1.peek()<=pq2.peek()){
                ans+=pq1.poll();
                if(next1<=next2){
                    pq1.add(costs[next1]);
                    next1++;
                }
            } 
            else{
                ans+=pq2.poll();
                if(next1<=next2){
                    pq2.add(costs[next2]);
                    next2--;
                }
            }
        }
        return ans;
    }
}