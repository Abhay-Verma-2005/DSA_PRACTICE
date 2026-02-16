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
        List<Double> ll = new ArrayList<>();
        Queue<TreeNode> q= new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size=q.size();
            double av=0;
            for(int i=0;i<size;i++){
                TreeNode val= q.poll();
                if(val.left!=null){
                    q.add(val.left);
                }
                if(val.right!=null){
                    q.add(val.right);
                }
                av+=val.val;
            }
            av=av/size;
            ll.add(av);

        }
        return ll;
    }
}