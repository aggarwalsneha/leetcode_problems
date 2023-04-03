class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        for(int i=0;i<numCourses;i++)
            adj.add(new ArrayList<>());
        for(int[] e:prerequisites)
        {
            adj.get(e[1]).add(e[0]);
        }
        int[] indegree=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            for(int j:adj.get(i))
                indegree[j]++;
        }
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(indegree[i]==0)
                q.offer(i);
        }
        ArrayList<Integer>arr=new ArrayList<>();
        while(!q.isEmpty())
        {
            int curr=q.poll();
            arr.add(curr);
            for(int num:adj.get(curr)){
                indegree[num]--;
                if(indegree[num]==0)
                    q.offer(num);
            }
        }
        if(arr.size()==numCourses){
            int[] ans=new int[numCourses];
            for(int i=0;i<numCourses;i++)
                ans[i]=arr.get(i);
            return ans;
        }
        else
            return new int[]{};
    }
}