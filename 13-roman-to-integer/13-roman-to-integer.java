class Solution {
    public int romanToInt(String s) {
        HashMap<Character,Integer> hmap=new HashMap<>();
    
        hmap.put('I',1);
        hmap.put('V',5);
        hmap.put('X',10);
        hmap.put('L',50);
        hmap.put('C',100);
        hmap.put('D',500);
        hmap.put('M',1000);
        int ans=0;
       for(int i=0;i<s.length()-1;i++)
       {
           if(hmap.get(s.charAt(i))>=hmap.get(s.charAt(i+1)))
                ans+=hmap.get(s.charAt(i));
           else
                ans-=hmap.get(s.charAt(i));
        }
        ans+=hmap.get(s.charAt(s.length()-1));
        return ans;
    }
}