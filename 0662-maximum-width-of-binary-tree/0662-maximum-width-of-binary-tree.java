class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> nodeQueue = new LinkedList<>();
        LinkedList<Long> indexQueue = new LinkedList<>();
        nodeQueue.offer(root);
        indexQueue.offer(0L);
        long maxWidth = 0;

        while (!nodeQueue.isEmpty()) {
            int levelSize = nodeQueue.size();
            long leftmost = indexQueue.peek();
            long rightmost = leftmost;

            for (int i = 0; i < levelSize; i++) {
                TreeNode node = nodeQueue.poll();
                long idx = indexQueue.poll();
                rightmost = idx;

                // Normalize index to prevent overflow
                long normalizedIdx = idx - leftmost;

                if (node.left != null) {
                    nodeQueue.offer(node.left);
                    indexQueue.offer(2 * normalizedIdx);
                }
                if (node.right != null) {
                    nodeQueue.offer(node.right);
                    indexQueue.offer(2 * normalizedIdx + 1);
                }
            }

            maxWidth = Math.max(maxWidth, rightmost - leftmost + 1);
        }

        return (int) maxWidth;
    }
}