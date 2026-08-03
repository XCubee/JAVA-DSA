class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        // Build Trie
        int[][] children = new int[100001][26];
        boolean[] isEnd = new boolean[100001];
        int trieSize = 1; // node 0 is root

        for (String root : dictionary) {
            int node = 0;
            for (int i = 0; i < root.length(); i++) {
                int idx = root.charAt(i) - 'a';
                if (children[node][idx] == 0) {
                    children[node][idx] = trieSize++;
                }
                node = children[node][idx];
                // If a shorter root already ends here, skip the rest
                if (isEnd[node]) break;
            }
            isEnd[node] = true;
        }

        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();

        for (int w = 0; w < words.length; w++) {
            if (w > 0) result.append(" ");

            // Search Trie for shortest root prefix
            int node = 0;
            boolean found = false;
            for (int i = 0; i < words[w].length(); i++) {
                int idx = words[w].charAt(i) - 'a';
                if (children[node][idx] == 0) break;
                node = children[node][idx];
                if (isEnd[node]) {
                    result.append(words[w], 0, i + 1);
                    found = true;
                    break;
                }
            }

            if (!found) result.append(words[w]);
        }

        return result.toString();
    }
}