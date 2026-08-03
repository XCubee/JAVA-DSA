class Solution {
    public List<String> removeSubfolders(String[] folder) {
        // Build trie using nested HashMaps
        // A special key "" marks end-of-folder
        Map<String, Object> root = new HashMap<>();

        for (String path : folder) {
            String[] parts = path.split("/");
            Map<String, Object> node = root;
            for (int i = 1; i < parts.length; i++) {
                node.putIfAbsent(parts[i], new HashMap<>());
                node = (Map<String, Object>) node.get(parts[i]);
            }
            node.put("", null); // Mark end of folder
        }

        // DFS to collect root folders
        List<String> result = new ArrayList<>();
        dfs(root, new StringBuilder(), result);
        return result;
    }

    private void dfs(Map<String, Object> node, StringBuilder path, List<String> result) {
        if (node.containsKey("")) {
            // This node is an end-of-folder, collect it and stop
            result.add(path.toString());
            return;
        }
        for (String key : node.keySet()) {
            path.append("/").append(key);
            dfs((Map<String, Object>) node.get(key), path, result);
            // Backtrack: remove the appended "/<key>"
            path.setLength(path.length() - key.length() - 1);
        }
    }
}