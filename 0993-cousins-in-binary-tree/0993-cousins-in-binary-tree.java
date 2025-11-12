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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root==null){
            return false;
        }
        Queue<TreeNode> qu=new LinkedList<>();
        qu.offer(root);
        
        while(!qu.isEmpty()){
            int levelsize=qu.size();
            boolean foundx=false;
            boolean foundy=false;

            for(int i=0;i<levelsize;i++){
                TreeNode node=qu.poll();
                if(node.left!=null && node.right!=null){
                    if((node.left.val==x && node.right.val==y) || (node.left.val==y && node.right.val==x)){
                        return false;
                    }
                }
                if(node.val==x) foundx=true;
                if(node.val==y) foundy=true;

                if(node.left!=null) qu.offer(node.left);
                if(node.right!=null) qu.offer(node.right);
            }
            if(foundx && foundy) return true;
            if(foundx || foundy) return false;
            
        }
        return false;
    }
}