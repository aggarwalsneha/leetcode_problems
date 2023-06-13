class Solution {
    public int equalPairs(int[][] grid) {
        int count=0;
        Map<String,Integer>hm=new HashMap<>();
        for(int i=0;i<grid.length;i++){
            String str="";
            for(int j=0;j<grid[i].length;j++){
                str+=grid[i][j]+" ";
            }
            hm.put(str,hm.getOrDefault(str,0)+1);
        }
        for(int i=0;i<grid[0].length;i++){
            String str="";
            for(int j=0;j<grid.length;j++){
                str+=grid[j][i]+" ";
            }
            if(hm.containsKey(str))
                count+=hm.get(str);
        }
        return count;
    }
}