class Solution {
    
    class Pair{
    int pos;
    double t;
    public Pair(int pos,double t)
    {
        this.pos=pos;
        this.t=t;
    }
    }
        
    public int carFleet(int target, int[] position, int[] speed) {
        int n=position.length;
        Pair[] pairs=new Pair[n];
        for(int i=0;i<n;i++)
        {
            double time=(target-position[i])*1.0/speed[i];
            pairs[i]=new Pair(position[i],time);
        }
        Arrays.sort(pairs,(a,b)->b.pos-a.pos);
        int ans=1;
        for(int i=1;i<n;i++)
        {
            if(pairs[i].t<=pairs[i-1].t)
            {
                pairs[i].t=pairs[i-1].t;
            }
            else
                ans++;
                
        }
        return ans;
    }
}