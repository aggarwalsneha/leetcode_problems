class Solution {
    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        Queue<Pair> q=new PriorityQueue<>((a,b)->a.grp==b.grp?a.idx-b.idx:a.grp-b.grp);
        for(int i=0;i<groupSizes.length;i++){
            q.add(new Pair(groupSizes[i],i));
        }
        List<List<Integer>>ans=new ArrayList<>();
        List<Integer>temp=new ArrayList<>();
        while(!q.isEmpty()){
            Pair p=q.poll();
            if(temp.isEmpty() || (groupSizes[temp.get(temp.size()-1)]==p.grp && temp.size()<groupSizes[p.idx])){
                temp.add(p.idx);
            }
            else{
                ans.add(new ArrayList<>(temp));
                temp.clear();
                temp.add(p.idx);
            }
        }
        if(!temp.isEmpty())
            ans.add(temp);
        return ans;
    }
}

class Pair{
    int grp,idx;
    Pair(int grp,int idx){
        this.grp=grp;
        this.idx=idx;
    }
}