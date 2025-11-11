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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        qu.offer(root);
        while(!qu.isEmpty()){
            int levelsize=qu.size();
            List<Integer> currentlevel=new ArrayList<>();
            for(int i=0;i<levelsize;i++){
                TreeNode node=qu.poll();
                currentlevel.add(node.val);
                if(node.left!=null){
                    qu.offer(node.left);
                }
                if(node.right!=null){
                    qu.offer(node.right);
                }
            } 
            result.add(0,currentlevel);  

        }
        return result;
        
    }
}