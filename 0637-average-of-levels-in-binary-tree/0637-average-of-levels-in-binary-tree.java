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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> result=new ArrayList<>();
        if(root==null){
            return result;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        
        qu.offer(root);

        while(!qu.isEmpty()){
            int levelsize=qu.size();
            double average=0;
            for(int i=0;i<levelsize;i++){
                TreeNode node=qu.poll();
                average +=node.val;
                if(node.left!=null){
                    qu.offer(node.left);
                }
                if(node.right!=null){
                    qu.offer(node.right);
                }
                
            } 
            average=average/levelsize;
            result.add(average);          

        }
        return result;
        
    }
}