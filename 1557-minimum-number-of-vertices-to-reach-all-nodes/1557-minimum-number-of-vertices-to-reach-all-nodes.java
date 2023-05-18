class Solution {
    public List<Integer> findSmallestSetOfVertices(int n, List<List<Integer>> edges) {
        boolean[] flag=new boolean[n];
        for(List<Integer>e:edges){
            flag[e.get(1)]=true;
        }
        List<Integer>ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            if(!flag[i])
                ans.add(i);
        }
        return ans;
    }
}