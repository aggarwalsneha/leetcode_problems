class Solution {
    public boolean isPathCrossing(String path) {
        Set<String> hs=new HashSet<>();
        int x=0;
        int y=0;
        hs.add(x+"#"+y);
        for(int i=0;i<path.length();i++){
            char c=path.charAt(i);
            if(c=='N')
                y++;
            if(c=='S')
                y--;
            if(c=='E')
                x++;
            if(c=='W')
                x--;
            String str=x+"#"+y;
            if(hs.contains(str))
                return true;
            else 
                hs.add(str);
        }
        return false;
    }
}