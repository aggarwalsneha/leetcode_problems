class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        Deque<Integer> q=new ArrayDeque<>();
        int n=nums.length;
        for(int i=0;i<n;i++)
        {
            if(!q.isEmpty() && q.peek()<=i-k)
            q.poll();
            while(!q.isEmpty() && nums[q.peekLast()]<nums[i])
            q.pollLast();
            
            q.offer(i);
            if(i>=k-1)
            ans.add(nums[q.peek()]);
        }
        int[] res=new int[n-k+1];
        int i=0;
        for(int num:ans)
            res[i++]=num;
        return res;
    }
}