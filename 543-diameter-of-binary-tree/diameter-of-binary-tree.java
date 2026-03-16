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
    int d=0;
    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return d;
    }
    public int height(TreeNode root) {
        if(root==null) return 0;
        int l= height(root.left);
        int r= height(root.right);
        int dia=l+r;
        d=Math.max(d,dia);
        return Math.max(l,r)+1;
    }
}