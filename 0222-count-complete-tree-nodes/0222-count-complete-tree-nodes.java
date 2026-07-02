/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        // Compute depth going all the way left
        int leftDepth = 0;
        TreeNode left = root;
        while (left != null) {
            leftDepth++;
            left = left.left;
        }

        // Compute depth going all the way right
        int rightDepth = 0;
        TreeNode right = root;
        while (right != null) {
            rightDepth++;
            right = right.right;
        }

        // If depths match, this is a perfect binary tree
        if (leftDepth == rightDepth) {
            return (1 << leftDepth) - 1;
        }

        // Otherwise, recurse into both subtrees
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
}