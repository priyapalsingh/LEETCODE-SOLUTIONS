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
    int preindex=0;
    Map<Integer,Integer> indexmap=new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            indexmap.put(inorder[i],i);
        }
        return helper(preorder,0,inorder.length-1);
        
    }
    private TreeNode helper(int[] preorder,int left,int right){
        if(left>right){
            return null;
        }
        int rootval=preorder[preindex++];
        TreeNode root=new TreeNode(rootval);

        int mid=indexmap.get(rootval);
        root.left= helper(preorder,left,mid-1);
        root.right=helper(preorder,mid+1,right);
        return root;
    }
}