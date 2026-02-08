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
    boolean ans=true;
    public boolean isBalanced(TreeNode root) {
        isBalancedH(root);
        return ans;
    }
    public int isBalancedH(TreeNode root){
        if (root==null) return 0;

        int l=isBalancedH(root.right);
        int r=isBalancedH(root.left);
        if (Math.abs(l-r)>1) {
            ans=false;
        }

        return 1+Math.max(l,r);
    }
}