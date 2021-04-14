package com.zhangyu.leetcoderecord.problems;

/**
 * Function: 208. 实现 Trie (前缀树)
 *
 * @author zhangyu
 * Date: 2021/4/14
 * @since JDK 1.8
 */
public class Solution00208 {

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));
        System.out.println(trie.search("app"));
        System.out.println(trie.startsWith("app"));
        trie.insert("app");
        System.out.println(trie.search("app"));

    }

    private static class Trie {

        private Trie[] sons;

        private boolean isEnd;

        /** Initialize your data structure here. */
        public Trie() {
            sons = new Trie[26];
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trie.sons[index] == null) {
                    trie.sons[index] = new Trie();
                }
                trie = trie.sons[index];
            }
            trie.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            Trie trie = this;
            for (int i = 0; i < word.length(); i++) {
                int index = word.charAt(i) - 'a';
                if (trie.sons[index] == null) {
                    return false;
                }
                trie = trie.sons[index];
            }
            return trie.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            Trie trie = this;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) - 'a';
                if (trie.sons[index] == null) {
                    return false;
                }
                trie = trie.sons[index];
            }
            return true;
        }
    }
}
