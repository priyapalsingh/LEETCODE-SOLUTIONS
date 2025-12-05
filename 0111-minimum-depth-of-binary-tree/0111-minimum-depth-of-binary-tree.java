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
    public int minDepth(TreeNode root) {
        if(root==null){
            return 0;
        }
        //dono hee child nahi hai 
        if(root.left==null && root.right==null ){
            return 1;
        }
        //ek hee child hai 
        if(root.left==null){
            return 1+ minDepth(root.right);
        }
        if(root.right==null){
            return 1+ minDepth(root.left);
        }
        //dono hee child hai 
        return 1+Math.min(minDepth(root.left),minDepth(root.right));
        
    }
}