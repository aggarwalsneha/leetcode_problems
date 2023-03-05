class Solution {
    public int minJumps(int[] arr) {
        int n=arr.length;
        if(n==1)
            return 0;
        HashMap<Integer,List<Integer>>hm=new HashMap<>();
        int ans=0;
        for(int i=0;i<n;i++){
            if(!hm.containsKey(arr[i]))
            hm.put(arr[i],new ArrayList<>());
            hm.get(arr[i]).add(i);
        }
        Queue<Integer>q=new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty())
        {
            ans++;
            int size=q.size();
            for(int i=0;i<size;i++)
            {
                int idx=q.poll();
                if(idx-1>=0 && hm.containsKey(arr[idx-1]))
                    q.offer(idx-1);
                if(idx+1<n && hm.containsKey(arr[idx+1]))
                {
                    if(idx+1==n-1)
                        return ans;
                    q.offer(idx+1);
                }
                if(hm.containsKey(arr[idx]))
                {
                    for(int num:hm.get(arr[idx]))
                    {
                        if(num!=idx)
                        {
                            if(num==n-1)
                                return ans;
                            q.offer(num);
                        }
                    }
                }
                hm.remove(arr[idx]);
            }
        }
        return ans;
    }
}