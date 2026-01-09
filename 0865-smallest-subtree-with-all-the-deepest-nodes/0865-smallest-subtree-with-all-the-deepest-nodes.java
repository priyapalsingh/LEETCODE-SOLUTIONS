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
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
            return dfs(root).node;                
    }
    private Pair dfs(TreeNode root){
        if(root==null){
            return new Pair(null,0);
        }
        Pair L=dfs(root.left) ;
        Pair R=dfs(root.right);

        if(L.depth>R.depth) return new Pair(L.node, L.depth+1);
        if(R.depth>L.depth) return new Pair(R.node, R.depth+1);
        return new Pair(root,L.depth+1);
    }
    private static class Pair {
        TreeNode node;
        int depth;
        Pair(TreeNode n, int d) {
            node = n;
            depth = d;
        }
    }
}