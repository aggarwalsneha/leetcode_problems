class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> r=new LinkedList<>();
        Queue<Integer>d=new LinkedList<>();
        for(int i=0;i<senate.length();i++){
            if(senate.charAt(i)=='R')
                r.add(i);
            else
                d.add(i);
        }
        int n=senate.length();
        while(!r.isEmpty() && !d.isEmpty()){
            int r_i=r.poll();
            int d_i=d.poll();
            if(r_i<d_i)
                r.add(r_i+n);
            else
                d.add(d_i+n);
        }
        return r.size()>d.size()?"Radiant":"Dire";
    }
}