// https://leetcode.com/problems/add-and-search-word-data-structure-design/

// https://leetcode.com/problems/add-and-search-word-data-structure-design/

public class WordDictionary {
    
    public class TrieNode {
        boolean isWord;
        TrieNode[] next;
        public TrieNode() {
            this.isWord = false;
            this.next = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    
    public WordDictionary(){
        root = new TrieNode();
    }
    
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.next[c - 'a'] == null){
                node.next[c - 'a'] = new TrieNode();
            }
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return helper(word, 0, root);
    }
    
    private boolean helper(String word, int index, TrieNode parent){
        TrieNode node = parent;
        for(int i = index; i < word.length(); i++){
            char c = word.charAt(i);
            if(c != '.'){
                if(node.next[c - 'a'] == null){
                    return false;
                }
                node = node.next[c - 'a'];
            }
            else{
                for(char l = 'a'; l <= 'z'; l++){
                    if(node.next[l - 'a'] != null){
                        if(helper(word, i + 1, node.next[l - 'a'])){
                            return true;
                        }
                    }
                }
                return false;
            }
        }
        return (node != null && node.isWord);
    }
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");