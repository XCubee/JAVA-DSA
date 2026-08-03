import java.util.*;

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isEnd = false;
}

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        TrieNode root = new TrieNode();

        // Build trie
        for (String word : dictionary) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];

                // Optional optimization:
                // if a shorter root already ends here, no need to go deeper
                if (node.isEnd) {
                    break;
                }
            }
            node.isEnd = true;
        }

        StringBuilder result = new StringBuilder();
        String[] words = sentence.split(" ");

        for (int i = 0; i < words.length; i++) {
            if (i > 0) result.append(" ");
            result.append(getRoot(words[i], root));
        }

        return result.toString();
    }

    private String getRoot(String word, TrieNode root) {
        TrieNode node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            int idx = ch - 'a';

            if (node.children[idx] == null) {
                return word;
            }

            node = node.children[idx];

            if (node.isEnd) {
                return word.substring(0, i + 1);
            }
        }

        return word;
    }
}