class Solution {
    public int numberOfWays(String corridor) {
        List<Integer> seats=new ArrayList<>();
        int mod=(int)1e9+7;
        for(int i=0;i<corridor.length();i++){
            if(corridor.charAt(i)=='S'){
                seats.add(i);        
            }
        }
        if(seats.size()==0 || seats.size()%2!=0){
            return 0;
        }
        long ans=1;
        int prev=seats.get(1);
        for(int i=2;i<seats.size();i+=2){
            int len=seats.get(i)-prev;
            ans=(ans*len)%mod;
            prev=seats.get(i+1);
        }
        
        return (int)ans;
    }
}