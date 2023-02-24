class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> q=new PriorityQueue<>(Collections.reverseOrder());
        int min=Integer.MAX_VALUE;
        for(int num:nums){
            if(num%2==1)
                num=num*2;
            q.offer(num);
            min=Math.min(min,num);
        }
        int ans=Integer.MAX_VALUE;
        while(true){
            int max=q.poll();
            ans=Math.min(ans,max-min);
            if(max%2==1)
                break;
            max=max/2;
            min=Math.min(min,max);
            q.offer(max);
        }
        return ans;
    }
}