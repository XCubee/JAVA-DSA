class Solution {
    // Declare as class-level variables so both methods can access them
    int mindiff = Integer.MAX_VALUE;
    Integer prev = null; 

    public int getMinimumDifference(TreeNode root) {
        inorder(root);
        return mindiff;
    }

    void inorder(TreeNode root) {
        if (root == null) return;

        // 1. Traverse Left
        inorder(root.left);

        // 2. Process Current Node
        if (prev != null) {
            mindiff = Math.min(mindiff, root.val - prev);
        }
        prev = root.val; // Move prev pointer to current node value

        // 3. Traverse Right
        inorder(root.right);
    }
}