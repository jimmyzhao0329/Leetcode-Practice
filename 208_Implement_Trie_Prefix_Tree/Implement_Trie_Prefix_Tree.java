// https://leetcode.com/problems/implement-trie-prefix-tree/

class TrieNode {
    // Initialize your data structure here.
    public boolean isWord;
    public TrieNode[] next;
    
    public TrieNode(){
        this.isWord = false;
        this.next = new TrieNode[26];
    }
}

public class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()){
            if(p.next[c - 'a'] == null){
                p.next[c - 'a'] = new TrieNode();
            }
            p = p.next[c - 'a'];
        }
        p.isWord = true;
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode p = root;
        for(char c : word.toCharArray()){
            if(p.next[c - 'a'] == null){
                return false;
            }
            p = p.next[c - 'a'];
        }
        return p.isWord;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode p = root;
        for(char c : prefix.toCharArray()){
            if(p.next[c - 'a'] == null){
                return false;
            }
            p = p.next[c - 'a'];
        }
        return true;
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");