// https://leetcode.com/problems/word-ladder/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if(beginWord == null || beginWord.length() == 0
            || endWord == null || endWord.length() == 0
            || wordList.size() == 0){
                return 0;
        }
        
        Queue<String> q = new LinkedList<String>();
        q.offer(beginWord);
        wordList.remove(beginWord);
        int length = 1;
        while(!q.isEmpty()){
            int len = q.size();
            for(int i = 0; i < len; i++){
                String cur = q.poll();
                for(char c = 'a'; c <= 'z'; c++){
                    for(int j = 0; j < cur.length(); j++){
                        if(c == cur.charAt(j)){
                            continue;
                        }
                        char[] curChar = cur.toCharArray();
                        curChar[j] = c;
                        String temp = new String(curChar);
                        if(temp.equals(endWord)){
                            return length + 1;
                        }
                        if(wordList.contains(temp)){
                            q.offer(temp);
                            wordList.remove(temp);
                        }
                    }
                }
            }
            length++;
        }
        return 0;
    }
}