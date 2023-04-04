class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words=new HashSet<>(wordList);
        Queue<Pair>q=new LinkedList<>();
        q.offer(new Pair(beginWord,1));
        if(words.contains(beginWord))
            words.remove(beginWord);
        while(!q.isEmpty())
        {
            Pair curr=q.poll();
            String w=curr.str;
            int steps=curr.c;
            if(w.equals(endWord))
                return steps;
            for(int i=0;i<w.length();i++){
                for(char c='a';c<='z';c++){
                    char[] currW=w.toCharArray();
                    currW[i]=c;
                    String new_str=new String(currW);
                    if(words.contains(new_str)){
                        words.remove(new_str);
                        q.offer(new Pair(new_str,steps+1));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    String str;
    int c;
    Pair(String str,int c)
    {
        this.str=str;
        this.c=c;
    }
}