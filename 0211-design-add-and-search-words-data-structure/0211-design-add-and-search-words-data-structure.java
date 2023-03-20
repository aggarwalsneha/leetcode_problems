class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        String word;
    }
    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode(); 
    }
    
    public void addWord(String word) {
        TrieNode curr=root;
        for(char c: word.toCharArray()){
            if(curr.children[c-'a']== null)
                curr.children[c -'a'] = new TrieNode();
            curr=curr.children[c - 'a'];
        }
        curr.word=word;    
    }
    
    public boolean search(String word) {
        return wordSearch(word.toCharArray(),0,root);
    }
    public boolean wordSearch(char[] word,int i,TrieNode curr) {
        if(i==word.length)
            return curr.word!=null;
        while(i<word.length && word[i]!='.'){
            if(curr.children[word[i] - 'a'] == null)
                return false;
            curr=curr.children[word[i] - 'a'];
            i++;
        }
        if(i==word.length)
            return curr.word != null;
        else{
            for(int j = 0; j < curr.children.length; j++){
                if(curr.children[j] != null)
                    if(wordSearch(word, i + 1, curr.children[j]))
                        return true;
            }
            return false;
        }                      
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */