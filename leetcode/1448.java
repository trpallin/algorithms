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
    private int goodNodes(TreeNode root, int maxValue) {
        if (root == null) {
            return 0;
        }
        if (root.val >= maxValue) {
            return goodNodes(root.left, root.val) + goodNodes(root.right, root.val) + 1;
        }
        return goodNodes(root.left, maxValue) + goodNodes(root.right, maxValue);
    }
    
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }
}