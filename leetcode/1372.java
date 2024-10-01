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
    private int longestLength = 0;

    private void longestZigZag(TreeNode root, boolean left, int current) {
        if (root == null) {
            return;
        }
        longestLength = Math.max(longestLength, current);
        if (left) {
            longestZigZag(root.left, !left, current + 1);
            longestZigZag(root.right, true, 1);
        } else {
            longestZigZag(root.right, !left, current + 1);
            longestZigZag(root.left, false, 1);
        }
    }

    public int longestZigZag(TreeNode root) {
        longestZigZag(root, true, 0);
        return longestLength;
    }
}