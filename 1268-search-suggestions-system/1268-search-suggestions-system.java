class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        List<String> suggestions = new ArrayList<>();
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        TrieNode root = new TrieNode();

        // Insert in sorted order so each node keeps the 3 smallest matches
        for (String product : products) {
            TrieNode node = root;
            for (char c : product.toCharArray()) {
                int idx = c - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
                if (node.suggestions.size() < 3) {
                    node.suggestions.add(product);
                }
            }
        }

        List<List<String>> result = new ArrayList<>();
        TrieNode node = root;
        for (int i = 0; i < searchWord.length(); i++) {
            if (node != null) {
                node = node.children[searchWord.charAt(i) - 'a'];
            }
            result.add(node == null ? new ArrayList<>() : node.suggestions);
        }

        return result;
    }
}