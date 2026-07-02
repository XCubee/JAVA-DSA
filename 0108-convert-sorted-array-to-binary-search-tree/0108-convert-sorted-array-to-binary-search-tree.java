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
    public TreeNode sortedArrayToBST(int[] nums) {
        return build(nums, 0, nums.length - 1);
    }

    private TreeNode build(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        // Pick the middle element as the root of this subtree (normalized)
        int mid = left + (right - left) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        // Recursively build left and right subtrees from remaining halves
        node.left = build(nums, left, mid - 1);
        node.right = build(nums, mid + 1, right);
        return node;
    }
}