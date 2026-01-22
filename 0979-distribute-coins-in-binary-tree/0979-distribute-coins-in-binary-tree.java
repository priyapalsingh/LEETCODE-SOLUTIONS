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
    int moves=0;
    public int distributeCoins(TreeNode root) {
        dfs(root);
        return moves;        
    }
    private int dfs(TreeNode root){
        if(root==null) return 0;
        int leftExtra=dfs(root.left);
        int rightExtra=dfs(root.right);

        moves+=Math.abs(leftExtra)+Math.abs(rightExtra);
        return leftExtra + rightExtra + root.val-1;

    }
}