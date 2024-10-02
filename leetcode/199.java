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
    private int depth = 0;

    private void traverse(TreeNode node, int currentDepth, List<Integer> rightSides) {
        if (node == null) {
            return;
        }
        if (currentDepth > depth) {
            rightSides.add(node.val);
            depth++;
        }
        traverse(node.right, currentDepth + 1, rightSides);
        traverse(node.left, currentDepth + 1, rightSides);
    }

    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> rightSides = new ArrayList<>();
        rightSides.add(root.val);
        traverse(root, 0, rightSides);
        return rightSides;
    }
}