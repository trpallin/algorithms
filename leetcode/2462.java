class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        long cost = 0L;
        PriorityQueue<Integer> leftHeap = new PriorityQueue<>();
        PriorityQueue<Integer> rightHeap = new PriorityQueue<>();
        int n = costs.length;
        int left = 0, right = n - 1;

        if (2 * candidates <= n) {
            for (int i = 0; i < candidates; i++) {
                leftHeap.add(costs[i]);
                rightHeap.add(costs[n - 1 - i]);
            }
            left += candidates;
            right -= candidates;
        } else {
            for (int i = 0; i < n; i++) {
                leftHeap.add(costs[i]);
            }
            left = right + 1;
        }

        while (k-- > 0) {
            int leftVal = leftHeap.isEmpty() ? Integer.MAX_VALUE : leftHeap.peek();
            int rightVal = rightHeap.isEmpty() ? Integer.MAX_VALUE : rightHeap.peek();
            if (leftVal <= rightVal) {
                cost += leftHeap.remove();
                if (left <= right) {
                    leftHeap.add(costs[left++]);
                }
            } else {
                cost += rightHeap.remove();
                if (left <= right) {
                    rightHeap.add(costs[right--]);
                }
            }
        }
        
        return cost;
    }
}