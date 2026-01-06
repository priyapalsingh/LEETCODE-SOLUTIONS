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
    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 0;
        int maxSum = Integer.MIN_VALUE;
        int bestLevel = 1;
        
        while (!q.isEmpty()) {
            int size = q.size();
            int levelSum = 0;
            
            // process current level
            for (int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                levelSum += node.val;
                
                if (node.left != null) q.offer(node.left);
                if (node.right != null) q.offer(node.right);
            }
            
            // check if current level has max sum
            level++;
            if (levelSum > maxSum) {
                maxSum = levelSum;
                bestLevel = level;
            }
        }
        
        return bestLevel;
    }
}
