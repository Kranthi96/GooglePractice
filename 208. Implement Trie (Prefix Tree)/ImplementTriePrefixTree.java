class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word){
        TrieNode temp = root;
        for(char c: word.toCharArray()){
            if(!temp.containsKey(c))
                temp.put(c, new TrieNode());
            temp = temp.get(c);
        }
        temp.setEnd();
    }

    public TrieNode searchPrefix(String prefix){
        TrieNode node = root;
        for(int i=0;i<prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.containsKey(c)) node = node.get(c);
            else return null;
        }
        return node;
    }
    
    
    public boolean search(String word) {
        TrieNode node= searchPrefix(word);
        return node!=null && node.isEnd();
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode node= searchPrefix(prefix);
        return node!=null;
    }
}

class TrieNode{
    private TrieNode[] links;
    private final int R =26;
    private boolean isEnd;
    public TrieNode(){
        links = new TrieNode[R];
    }
    public boolean containsKey(char c){
        return links[c-'a'] !=null;
    }
    public TrieNode get(char c){
        return links[c-'a'];
    }
    public void put(char c,TrieNode node){
        links[c-'a'] = node;
    }
    public boolean isEnd(){
        return isEnd;
    }
    public void setEnd(){
        isEnd = true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
