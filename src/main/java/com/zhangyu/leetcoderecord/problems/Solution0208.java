package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 208. 实现 Trie (前缀树)
 *
 * @author zhangyu
 * Date: 2020/10/23 12:09
 * @since JDK 1.8
 */
public class Solution0208 {

    public static void main(String[] args) {
        Trie trie = new Trie();

        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));
    }

    static class Trie {

        public Character character;
        public Trie[] sons;
        private int size = 26;
        private boolean isEnd = false;

        /** Initialize your data structure here. */
        public Trie() {
            sons = new Trie[size];
            character = ' ';
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie current = this;
            for (char c : word.toCharArray()) {
                Trie son = current.sons[c - 'a'];
                if ( son == null) {
                    Trie trie = new Trie();
                    trie.character = c;
                    current.sons[c - 'a'] = trie;
                    current = trie;
                } else {
                    current = son;
                }
            }
            current.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie current = this;
            for (char c : word.toCharArray()) {
                Trie son = current.sons[c - 'a'];
                if (son == null) {
                    return false;
                }
                current = son;
            }
            return current.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie current = this;
            for (char c : prefix.toCharArray()) {
                Trie son = current.sons[c - 'a'];
                if (son == null) {
                    return false;
                }
                current = son;
            }
            return true;
        }
    }
}
