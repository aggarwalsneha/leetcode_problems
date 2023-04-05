class Solution {
    static Map<String,Integer>hm;
    static List<List<String>> ans;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        hm=new HashMap<>();
        Set<String>hs=new HashSet<>();
        for(String s:wordList)
        hs.add(s);
        ans=new ArrayList<>();
        Queue<String>q=new LinkedList<>();
        q.offer(beginWord);
        hm.put(beginWord,1);
        hs.remove(beginWord);
        while(!q.isEmpty())
        {
            String word=q.poll();
            int steps=hm.get(word);
            if(word.equals(endWord))
            break;
            for(int i=0;i<word.length();i++){
                for(char ch='a';ch<='z';ch++){
                    char[] new_arr=word.toCharArray();
                    new_arr[i]=ch;
                    String new_str=new String(new_arr);
                    if(hs.contains(new_str)){
                        q.offer(new_str);
                        hs.remove(new_str);
                        hm.put(new_str,steps+1);
                    }
                }
            }
        }
        if(hm.containsKey(endWord)){
            List<String>vec=new ArrayList<>();
            vec.add(endWord);
            dfs(endWord,vec,beginWord);
        }
        return ans;
    }
    public static void dfs(String word,List<String>vec,String beginWord){
        if(word.equals(beginWord)){
            Collections.reverse(vec);
            ans.add(new ArrayList<>(vec));
            Collections.reverse(vec);
            return;
        }
        int steps=hm.get(word);
        for(int i=0;i<word.length();i++){
            for(char ch='a';ch<='z';ch++){
                char[] new_arr=word.toCharArray();
                new_arr[i]=ch;
                String new_str=new String(new_arr);
                if(hm.containsKey(new_str) && hm.get(new_str)+1==steps){
                    vec.add(new_str);
                    dfs(new_str,vec,beginWord);
                    vec.remove(vec.size()-1);
                }
            }
        }
    }
}