class Solution {
    public int minSpeedOnTime(int[] dist, double hour) {
        int start=1,end=10000000;
        int ans=-1;
        while(start<=end){
            int mid=(start+end)/2;
            if(solve(dist,mid)<=hour){
                ans=mid;
                end=mid-1;
            }
            else
                start=mid+1;
        }
        return ans;
    }
    
    public double solve(int[] dist,int speed){
        double time=0;
        for(int i=0;i<dist.length;i++){
            double t=(double)dist[i]/(double)speed;
            time+=(i==dist.length-1?t:Math.ceil(t));
        }
        return time;
    }
}