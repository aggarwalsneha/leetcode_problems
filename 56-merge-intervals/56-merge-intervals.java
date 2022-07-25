class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b)-> a[0]-b[0]);
        ArrayList<int[]> ans=new ArrayList<>();
        int[] current_interval=intervals[0];
        for(int i=1;i<intervals.length;i++)
        {
            if(current_interval[1]>=intervals[i][0])
            {
                if(current_interval[1]<intervals[i][1])
                    current_interval[1]=intervals[i][1];
            }
            else
            {
                ans.add(current_interval);
                current_interval=intervals[i];
            }
        }
        ans.add(current_interval);
        int[][] res=new int[ans.size()][2];
        
        return ans.toArray(res);
    }
}