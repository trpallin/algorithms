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
    private int dfs(TreeNode root, long currentSum, int targetSum, HashMap<Long, Integer> prefixSumCountMap) {
        if (root == null) {
            return 0;
        }
        currentSum += root.val;

        int countUntilCurrentNode = prefixSumCountMap.getOrDefault(currentSum - targetSum, 0);
        prefixSumCountMap.put(currentSum, prefixSumCountMap.getOrDefault(currentSum, 0) + 1);
        int left = dfs(root.left, currentSum, targetSum, prefixSumCountMap);
        int right = dfs(root.right, currentSum, targetSum, prefixSumCountMap);

        prefixSumCountMap.put(currentSum, prefixSumCountMap.getOrDefault(currentSum, 0) - 1);
        return countUntilCurrentNode + left + right;
    }

    public int pathSum(TreeNode root, int targetSum) {
        HashMap<Long, Integer> prefixSumCountMap = new HashMap<>();
        prefixSumCountMap.put(0L, 1);
        return dfs(root, 0L, targetSum, prefixSumCountMap);
    }
}