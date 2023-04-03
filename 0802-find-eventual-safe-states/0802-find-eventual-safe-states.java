class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>>adj=new ArrayList<>();
        int n=graph.length;
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int i=0;i<n;i++)
        {
            for(int j:graph[i])
                adj.get(j).add(i);
        }
        int[] indegree=new int[n];
        for(int i=0;i<n;i++)
        {
            for(int j:adj.get(i))
                indegree[j]++;
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0)
                q.add(i);
        }
        ArrayList<Integer>arr=new ArrayList<>();
        while(!q.isEmpty())
        {
            int curr=q.poll();
            arr.add(curr);
            for(int num:adj.get(curr))
            {
                indegree[num]--;
                if(indegree[num]==0)
                    q.add(num);
            }
        }
        Collections.sort(arr);
        return arr;
    }
}