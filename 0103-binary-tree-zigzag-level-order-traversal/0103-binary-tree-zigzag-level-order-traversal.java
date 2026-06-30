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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        List<List<Integer>> result = new ArrayList<>();
        if (root== null){return result;}

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level=0;

        while(!q.isEmpty()){
            int levelSize=q.size();

            List<Integer> temp = new ArrayList<>();
            for(int i =0;i<levelSize;i++){
                TreeNode t = q.poll();
                if(level%2==0){
                    temp.add(t.val);
                }
                else{
                    temp.add(0,t.val);
                }
                if(t.left!=null){q.add(t.left);}
                if(t.right!=null){q.add(t.right);}

            }
            result.add(temp);
            level++;
        } 
          return result;
            }
          
}