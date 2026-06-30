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
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean seenNull = false;
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();
            
            if (curr == null) {
                // Once we see a null, any subsequent node makes the tree incomplete
                seenNull = true;
            } else {
                // If we see a valid node after a null, it's not complete
                if (seenNull) {
                    return false;
                }
                // Push both left and right children, even if they are null
                queue.add(curr.left);
                queue.add(curr.right);
            }
        }
        
        return true;
    }
}