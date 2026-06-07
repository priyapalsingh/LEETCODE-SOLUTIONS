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
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer,TreeNode> map=new HashMap<>();
        Set<Integer> set=new HashSet<>();

        for(int[] arr : descriptions){
            int parent=arr[0];
            int child=arr[1];
            int isLeft=arr[2];

            map.putIfAbsent(parent,new TreeNode(parent));
            map.putIfAbsent(child,new TreeNode(child));

            TreeNode parentnode=map.get(parent);
            TreeNode childnode=map.get(child);

            if(isLeft==1){
                parentnode.left=childnode;
            }else{
                parentnode.right=childnode;
            }

            set.add(child);
        }
        for(int val:map.keySet()){
            if(!set.contains(val)){
                return map.get(val);
            }
        }
        return null;
        
    }
}