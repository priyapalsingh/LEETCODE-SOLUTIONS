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
    public int pathSum(TreeNode root, int targetSum) {
        if(root==null){
            return 0;
        }
      return countfrom(root,targetSum)+pathSum(root.left,targetSum)+pathSum(root.right,targetSum);
    }
    private int countfrom(TreeNode root,int sum){
        if(root==null) return 0;
        int count=0;
        if(root.val==sum){
            count++;
        }
        count += countfrom(root.left,sum-root.val);
        count += countfrom(root.right,sum-root.val);
        return count++;
    }
}