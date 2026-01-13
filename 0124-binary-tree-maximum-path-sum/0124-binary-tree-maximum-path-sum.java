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
    int maxsum=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxhelper(root);
        return maxsum;        
    }
    private int maxhelper(TreeNode root){
        if(root==null) return  0;

        int left=Math.max(0,maxhelper(root.left));
        int right=Math.max(0,maxhelper(root.right));

        maxsum=Math.max(maxsum,left+root.val+right);
        return root.val+Math.max(left,right);
    }
}