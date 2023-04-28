class Solution {
    
    public boolean isSimilar(String s1,String s2){
        int count=0;
        for(int i=0;i<s1.length();i++){
            if(s1.charAt(i)!=s2.charAt(i))
                count++;
            if(count>2)
                return false;
        }
        return count==2 || count==0;
    }
    
    public void dfs(Set<String> visited, String[] strs, String s){
        if(visited.contains(s))
            return;
        visited.add(s);
        for(int i=0;i<strs.length;i++){
            if(isSimilar(s,strs[i]))
                dfs(visited,strs,strs[i]);
        }
    }
    public int numSimilarGroups(String[] strs) {
        int count=0;
        if(strs==null || strs.length==0)
            return 0;
        Set<String> visited=new HashSet<>();
        for(String str:strs){
            if(!visited.contains(str)){
                dfs(visited,strs,str);
                count++;
            }
        }
        return count;
    }
}