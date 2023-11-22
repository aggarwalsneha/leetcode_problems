class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        Queue<Pair<Integer,Integer>> q=new LinkedList();
        q.offer(new Pair(0,0));
        List<Integer> ans=new ArrayList();
        while(!q.isEmpty()){
            Pair<Integer,Integer> p=q.poll();
            int r=p.getKey();
            int c=p.getValue();
            ans.add(nums.get(r).get(c));
            if(c==0 && r+1<nums.size()){
                q.offer(new Pair(r+1,c));
            }
            if(c+1<nums.get(r).size()){
                q.offer(new Pair(r,c+1));
            }
        }
        int[] res=new int[ans.size()];
        int i=0;
        for(int num:ans)
            res[i++]=num;
        return res;
    }
}