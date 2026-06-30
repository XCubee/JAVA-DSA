class Solution {
    private int maxWidth;
    private List<Long> leftmostIndices;

    public int widthOfBinaryTree(TreeNode root) {
        maxWidth = 0;
        leftmostIndices = new ArrayList<>();
        dfs(root, 0, 0L);
        return maxWidth;
    }

    private void dfs(TreeNode node, int depth, long index) {
        if (node == null) return;

        // First node at this depth is the leftmost
        if (depth == leftmostIndices.size()) {
            leftmostIndices.add(index);
        }

        long width = index - leftmostIndices.get(depth) + 1;
        maxWidth = Math.max(maxWidth, (int) width);

        // Normalize to prevent index overflow
        long normalizedIndex = index - leftmostIndices.get(depth);
        dfs(node.left, depth + 1, 2 * normalizedIndex);
        dfs(node.right, depth + 1, 2 * normalizedIndex + 1);
    }
}