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
    // recursive solution
    // void traverse(TreeNode node, List<Integer> res) {
    //     if (node == null) return;
    //     traverse(node.left, res);
    //     res.add(node.val);
    //     traverse(node.right, res);
    // }

    // public List<Integer> inorderTraversal(TreeNode root) {
    //     List<Integer> res = new ArrayList<>();
    //     traverse(root, res);
    //     return res;
    // }

    // iterative solution
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        TreeNode iter = root;
        Stack<TreeNode> prev = new Stack<>();

        while (iter != null || !prev.isEmpty()) {
            while (iter != null) {
                prev.push(iter);
                iter = iter.left;
            }
            iter = prev.pop();
            res.add(iter.val);
            iter = iter.right;
        }

        return res;
    }
}