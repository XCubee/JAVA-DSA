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
 */class Solution {
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return isMirror(root.left, root.right);
    }

    private boolean isMirror(TreeNode p, TreeNode q) {
        // 1. Base Case: Both are null -> match!
        if (p == null && q == null) {
            return true;
        }
        
        // 2. Base Case: Structural mismatch -> not a mirror
        if (p == null || q == null) {
            return false;
        }
        
        // 3. Base Case: Value mismatch -> not a mirror
        if (p.val != q.val) {
            return false;
        }

        // 4. The Combo Return: Cross-compare children (Outer with Outer, Inner with Inner)
        return isMirror(p.left, q.right) && isMirror(p.right, q.left);
    }
}