// https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode {
    public char val;
    public boolean isWord;
    public TrieNode[] next = new TrieNode[26];
    public TrieNode() {}
    public TrieNode(char c){
        TrieNode node = new TrieNode();
        node.val = c;
    }
    
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
        root.val = ' ';
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.next[c - 'a'] == null){
                node.next[c - 'a'] = new TrieNode(c);
            }
            node = node.next[c - 'a'];
        }
        node.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            if(node.next[c - 'a'] == null){
                return false;
            }
            node = node.next[c - 'a'];
        }
        return node.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            if(node.next[c - 'a'] == null){
                return false;
            }
            node = node.next[c - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");