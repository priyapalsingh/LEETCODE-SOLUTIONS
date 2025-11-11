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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int levelsize=qu.size();
            for(int i=0;i<levelsize;i++){
                TreeNode node=qu.poll();
                if(i==levelsize-1){
                    result.add(node.val);
                }
                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);
            }         
        }
        return result;
        
    }
}