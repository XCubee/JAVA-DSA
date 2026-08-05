class Solution {
    // Trie Node definition
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
        int childCount = 0; // Tracks the number of branches
    }

    private TrieNode root = new TrieNode();

    // Helper to insert a word into the Trie
    private void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = c - 'a';
            if (node.children[idx] == null) {
                node.children[idx] = new TrieNode();
                node.childCount++;
            }
            node = node.children[idx];
        }
        node.isEnd = true;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        // 1. Insert all strings into the Trie
        for (String str : strs) {
            // An empty string means the common prefix must be ""
            if (str.isEmpty()) return "";
            insert(str);
        }

        // 2. Traverse the Trie to find the longest common path
        StringBuilder prefix = new StringBuilder();
        TrieNode node = root;

        while (node.childCount == 1 && !node.isEnd) {
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    prefix.append((char) ('a' + i));
                    node = node.children[i];
                    break;
                }
            }
        }

        return prefix.toString();
    }
}