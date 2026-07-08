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
    public int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        inorder(root, values);
        int mindiff=Integer.MAX_VALUE;

        for(int i=1;i<values.size();i++){
             mindiff=Math.min(mindiff,(values.get(i) - values.get(i - 1)));
        }
        return mindiff;
    
    }
    void inorder(TreeNode root, List<Integer> result){
        if(root ==null) return;

        inorder(root.left,result);
        result.add(root.val);
        inorder(root.right,result);
    }
    
}