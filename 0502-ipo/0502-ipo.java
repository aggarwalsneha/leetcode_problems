class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        int n=capital.length;
        int[][] project=new int[n][2];
        for(int i=0;i<n;i++)
        {
            project[i][0]=capital[i];
            project[i][1]=profits[i];
        }
        Arrays.sort(project,(a,b)->a[0]==b[0]?b[1]-a[1]:a[0]-b[0]);
        PriorityQueue<Integer>q=new PriorityQueue<Integer>(n,Collections.reverseOrder());
        int i=0;
        while(k-->0)
        {
            while(i<n && project[i][0]<=w){
                q.offer(project[i][1]);
                i++;
            }
            if(q.isEmpty())
                break;
            w+=q.poll();
        }
        return w;
     }
}