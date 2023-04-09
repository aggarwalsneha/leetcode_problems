class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>>adj=new ArrayList<>();
        int n=colors.length();
        int[] indegree=new int[n];
        for(int i=0;i<n;i++)
            adj.add(new ArrayList<>());
        for(int[] e:edges){
            adj.get(e[0]).add(e[1]);
            indegree[e[1]]++;
        }
        int[][] t=new int[n][26];
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.offer(i);
                t[i][colors.charAt(i)-'a']=1;
            }
        }
        int ans=0,count=0;
        while(!q.isEmpty()){
            int node=q.poll();
            count++;
            ans=Math.max(ans,t[node][colors.charAt(node)-'a']);
            for(int num:adj.get(node)){
                for(int i=0;i<26;i++){
                    t[num][i]=Math.max(t[num][i],t[node][i]+(colors.charAt(num)-'a'==i?1:0));
                }
                indegree[num]--;
                if(indegree[num]==0)
                    q.offer(num);
            }
        }
        if(count<n)
            return -1;
        else
            return ans;
    }
}