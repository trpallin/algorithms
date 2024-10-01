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
    private void getLeaves(TreeNode root, List<Integer> leafValues) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            leafValues.add(root.val);
            return;
        }
        getLeaves(root.left, leafValues);
        getLeaves(root.right, leafValues);
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafValues1 = new ArrayList<>();
        List<Integer> leafValues2 = new ArrayList<>();
        getLeaves(root1, leafValues1);
        getLeaves(root2, leafValues2);
        return leafValues1.equals(leafValues2);
    }
}