class Trie {
    public Node root;
    public Trie() {
        root=new Node();
    }
    
    public void insert(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
            node.put(ch,new Node());
            node=node.get(ch);
        }
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
             return false;   
            node=node.get(ch);
        } 
        return node.ends();
    }
    
    public boolean startsWith(String word) {
        Node node=root;
        for(int i=0;i<word.length();i++)
        {
            char ch=word.charAt(i);
            if(!node.containsKey(ch))
             return false;   
            node=node.get(ch);
        } 
        return true;
        
    }
}

class Node{
    Node links[]=new Node[26];
    boolean flag=false;
    public Node(){
    }
    boolean containsKey(char ch){
    return (links[ch-'a']!=null);
    }

    void put(char ch,Node node){
    links[ch-'a']=node;
    }

    Node get(char ch){
    return links[ch-'a'];
    }

    void setEnd(){
    flag=true;
    }

    boolean ends(){
    return flag;
    }

}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */