/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private List<Integer> result = new ArrayList<>();

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        result.clear();
        dfs(root, target, k);
        return result;
    }

    // Returns distance from node to target, or -1 if target not in subtree
    private int dfs(TreeNode node, TreeNode target, int k) {
        if (node == null) return -1;

        if (node == target) {
            findDown(node, k);
            return 0;
        }

        int leftDist = dfs(node.left, target, k);
        if (leftDist != -1) {
            if (leftDist + 1 == k) {
                result.add(node.val);
            } else {
                findDown(node.right, k - leftDist - 2);
            }
            return leftDist + 1;
        }

        int rightDist = dfs(node.right, target, k);
        if (rightDist != -1) {
            if (rightDist + 1 == k) {
                result.add(node.val);
            } else {
                findDown(node.left, k - rightDist - 2);
            }
            return rightDist + 1;
        }

        return -1;
    }

    private void findDown(TreeNode node, int depth) {
        if (node == null || depth < 0) return;
        if (depth == 0) {
            result.add(node.val);
            return;
        }
        findDown(node.left, depth - 1);
        findDown(node.right, depth - 1);
    }
}