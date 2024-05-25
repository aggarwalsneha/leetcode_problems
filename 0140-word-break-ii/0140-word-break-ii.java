class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Map<Integer,List<String>> hm=new HashMap<>();
        for(int i=s.length();i>=0;i--){
            List<String> valid=new ArrayList<>();
            for(int j=i;j<s.length();j++){
                String curr=s.substring(i,j+1);
                if(wordInDict(curr,wordDict)){
                    if(j==s.length()-1){
                        valid.add(curr);
                    }
                    else{
                        List<String> arr = hm.get(j+1);
                        for(String snt:arr)
                            valid.add(curr+ " "+snt);
                    }
                }
            }
            hm.put(i,valid);
        }
        return hm.getOrDefault(0,new ArrayList<>());
    }
    public boolean wordInDict(String word,List<String> wordDict){
        return wordDict.contains(word);
    }
}