class Solution {
    Map<Integer,List<Integer>> graph=new HashMap();
    public int[] restoreArray(int[][] adjacentPairs) {
        for(int[] e:adjacentPairs) {
            int x=e[0];
            int y=e[1];
            if(!graph.containsKey(x)) {
                graph.put(x,new ArrayList());
            }
            if(!graph.containsKey(y)) {
                graph.put(y,new ArrayList());
            }
            graph.get(x).add(y);
            graph.get(y).add(x);
        }
        int root=0;
        for(int num:graph.keySet()){
            if(graph.get(num).size()==1){
                root=num;
                break;
            }
        }
        int[] ans=new int[graph.size()];
        dfs(root,Integer.MAX_VALUE,ans,0);
        return ans;
    }
    
    void dfs(int node,int prev,int[] ans,int i){
        ans[i]=node;
        for(int nbr:graph.get(node)){
            if(nbr!=prev){
                dfs(nbr,node,ans,i+1);
            }
        }
    }
}