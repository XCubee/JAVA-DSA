class Solution {
    TreeNode prev = null;

    public boolean isValidBST(TreeNode root) {
        return inorder(root); 
    }

    boolean inorder(TreeNode root) {
        if (root == null) return true;

        if (inorder(root.left) == false) {
            return false;
        }
        
        if (prev != null) {
            if (root.val <= prev.val) {
                return false;
            }
        }
        prev = root;
        
        if (inorder(root.right) == false) {
            return false;
        }
       
       
        return true; 
    }
}