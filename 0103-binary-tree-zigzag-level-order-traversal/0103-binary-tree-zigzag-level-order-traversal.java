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
       
        Deque<TreeNode> deq=new LinkedList<>();
        List<List<Integer>> result=new ArrayList<>();
         if(root==null){
            return result;
        }
        deq.offer(root);
        boolean reverse=false;
        while(!deq.isEmpty()){
            int levelsize=deq.size();
            List<Integer> list=new ArrayList<>();
            for(int i=0;i<levelsize;i++){
                if(!reverse){
                    TreeNode node=deq.pollFirst();
                    list.add(node.val);

                    if(node.left!=null){
                        deq.addLast(node.left);
                    }
                    if(node.right!=null){
                        deq.addLast(node.right);
                    }
                }
                else{
                    TreeNode node=deq.pollLast();
                    list.add(node.val);

                    if(node.right!=null){
                        deq.addFirst(node.right);
                    }
                    if(node.left!=null){
                        deq.addFirst(node.left);
                    }
                }
                
            }
            result.add(list);
                reverse=!reverse;
        }
        return result;
        
    }
}