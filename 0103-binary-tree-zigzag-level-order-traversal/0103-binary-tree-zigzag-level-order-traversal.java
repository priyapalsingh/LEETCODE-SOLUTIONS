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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        qu.offer(root);
        for(int level=0;!qu.isEmpty();level++){
            int levelsize=qu.size();
            ArrayList<Integer> currentlevel=new ArrayList<>();
            
            for(int i=0;i<levelsize;i++){
                TreeNode node=qu.poll();
                if(level%2==0){
                    currentlevel.addLast(node.val);
                }else{
                    currentlevel.addFirst(node.val);
                }
                if(node.left!=null){
                    qu.offer(node.left);
                }
                if(node.right !=null){
                    qu.offer(node.right);
                }
            } 
             result.add(currentlevel);
        }
        
        return result;
    }
}