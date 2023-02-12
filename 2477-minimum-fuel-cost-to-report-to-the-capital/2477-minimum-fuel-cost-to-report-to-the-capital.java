class Solution {
    long ans=0;
    public long minimumFuelCost(int[][] roads, int seats) {
        List<List<Integer>>graph=new ArrayList();
        for(int i=0;i<=roads.length;i++)
            graph.add(new ArrayList());
        for (int[] r:roads){
            graph.get(r[0]).add(r[1]);
            graph.get(r[1]).add(r[0]);
        }
        dfs(0,0,graph,seats);
        return ans;
        }
    public int dfs(int i,int prev,List<List<Integer>> graph,int s){
    int people=1;
    for(int x:graph.get(i)){
        if(x==prev)
           continue;
        people+=dfs(x,i,graph,s);
    }
    if(i!= 0)
        ans+=(long)Math.ceil(people*1.0/s);
    return people;
}
}