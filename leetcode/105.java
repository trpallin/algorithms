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
    private Map<Integer, Integer> inorderMap;

    private TreeNode buildTreeRecursive(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd) {
        if (inStart > inEnd) {
            return null;
        }
        int foundIdx = inorderMap.get(preorder[preStart]);
        int leftSize = foundIdx - inStart;
        TreeNode left = buildTreeRecursive(preorder, preStart + 1, inorder, inStart, foundIdx - 1);
        TreeNode right = buildTreeRecursive(preorder, preStart + 1 + leftSize, inorder, foundIdx + 1, inEnd);
        TreeNode node = new TreeNode(preorder[preStart], left, right);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderMap = new HashMap<>();
        for (int i = 0; i < preorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return buildTreeRecursive(preorder, 0, inorder, 0, inorder.length - 1);
    }
}