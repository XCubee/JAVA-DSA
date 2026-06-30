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
    public boolean isCompleteTree(TreeNode root) {
        int totalNodes = countNodes(root);
        return checkIndices(root, 1, totalNodes);
    }
    
    // Helper to count total nodes in the tree
    private int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    // Helper to verify if any node index exceeds the total count
    private boolean checkIndices(TreeNode root, int index, int totalNodes) {
        if (root == null) return true;
        
        // If the current node's index is greater than the total node count,
        // it means there is a gap somewhere earlier in the tree.
        if (index > totalNodes) return false;
        
        // Recursively check left and right subtrees with their respective indices
        return checkIndices(root.left, 2 * index, totalNodes) 
            && checkIndices(root.right, 2 * index + 1, totalNodes);
    }
}