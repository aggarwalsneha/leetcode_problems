class Solution {
    int[] ans,count;
    List<Set<Integer>> tree;
    public int[] sumOfDistancesInTree(int n, int[][] edges) {
        tree=new ArrayList<Set<Integer>>();
        ans=new int[n];
        count=new int[n];
        Arrays.fill(count,1);
        for(int i=0;i<n;i++)
        tree.add(new HashSet<Integer>());
        for(int[] e:edges)
        {
            tree.get(e[0]).add(e[1]);
            tree.get(e[1]).add(e[0]);
        }
        postorder(0,-1);
        preorder(0,-1);
        return ans;
    }

    public void postorder(int node,int pre)
    {
        for(int v:tree.get(node))
        {
            if(v!=pre)
            {
                postorder(v,node);
                count[node]+=count[v];
                ans[node]+=ans[v]+count[v];
            }
        }
    }
    public void preorder(int node,int pre)
    {
        for(int v:tree.get(node))
        {
            if(v!=pre)
            {
                ans[v]=ans[node]-count[v]+count.length-count[v];
                preorder(v,node);
            }
        }
    }
}