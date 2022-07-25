class Solution {
    public boolean hasGroupsSizeX(int[] deck) {
         HashMap<Integer,Integer> hmap = new HashMap<>();
        for(int i=0;i<deck.length;i++)
        {
            if(hmap.containsKey(deck[i])){  
            hmap.put(deck[i], hmap.get(deck[i])+1);
            }
            else{
            hmap.put(deck[i],1);
            }
        }
               int value=hmap.get(deck[0]);
          for(var v :hmap.values())
        {
            value=gcd(Math.max(v,value),Math.min(v,value));
        }
          if(value>1)
            return true;
        return false;
    }
    
    static int gcd(int a,int b)
{
    if(b==0)
    return a;
    return gcd(b,a%b);
}
}