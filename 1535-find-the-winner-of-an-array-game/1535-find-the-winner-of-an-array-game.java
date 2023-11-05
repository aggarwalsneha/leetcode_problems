class Solution {
    public int getWinner(int[] arr, int k) {
        int max=arr[0];
        Queue<Integer>q=new LinkedList<>();
        for(int i=1;i<arr.length;i++){
            max=Math.max(arr[i],max);
            q.offer(arr[i]);
        }
        int curr=arr[0];
        int win=0;
        while(!q.isEmpty()){
            int opp=q.poll();
            if(curr>opp){
                q.offer(opp);
                win++;
            }
            else{
                q.offer(curr);
                curr=opp;
                win=1;
            }
            if(win==k || curr==max)
                return curr;
        }
        return -1;
    }
}