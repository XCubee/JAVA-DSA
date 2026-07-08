class Solution {
    public int getMinimumDifference(TreeNode root) {
        int minDiff = Integer.MAX_VALUE;
        TreeNode current = root;
        TreeNode prev = null;

        while (current != null) {
            if (current.left == null) {
                // No left child: process current, move right
                if (prev != null) {
                    minDiff = Math.min(minDiff, current.val - prev.val);
                }
                prev = current;
                current = current.right;
            } else {
                // Find inorder predecessor (rightmost in left subtree)
                TreeNode predecessor = current.left;
                while (predecessor.right != null && predecessor.right != current) {
                    predecessor = predecessor.right;
                }

                if (predecessor.right == null) {
                    // Create thread and go left
                    predecessor.right = current;
                    current = current.left;
                } else {
                    // Thread exists: left subtree done, process current
                    predecessor.right = null;
                    if (prev != null) {
                        minDiff = Math.min(minDiff, current.val - prev.val);
                    }
                    prev = current;
                    current = current.right;
                }
            }
        }
        return minDiff;
    }
}