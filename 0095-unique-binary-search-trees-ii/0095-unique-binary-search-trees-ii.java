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
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return helper(1, n);
    }
    private List<TreeNode> helper(int start , int end){
        List<TreeNode> allTrees=new ArrayList<TreeNode>();
        if(start>end){
            allTrees.add(null);
            return allTrees;
        }
        for(int i=start ; i<=end ; i++){
            List<TreeNode> leftTree = helper(start,i-1);
            List<TreeNode> rightTree = helper(i+1,end);

            for(TreeNode left:leftTree){
                for(TreeNode right:rightTree){
                    TreeNode currentRoot = new TreeNode(i);
                    currentRoot.left = left;
                    currentRoot.right = right;
                    allTrees.add(currentRoot); 
                }
            }
        }
        return allTrees;
        

    }
}