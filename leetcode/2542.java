class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < nums1.length; i++) {
            list.add(new int[] {nums1[i], nums2[i]});
        }
        Collections.sort(list, (n1, n2) -> Integer.compare(n2[1], n1[1]));
        Queue<Integer> minHeap = new PriorityQueue<>();
        long sum = 0;
        for (int i = 0; i < k; i++) {
            int val = list.get(i)[0];
            minHeap.add(val);
            sum += val;
        }
        long maxScore = sum * list.get(k - 1)[1];

        for (int i = k; i < nums1.length; i++) {
            int val = list.get(i)[0];
            minHeap.add(val);
            sum += val;
            sum -= minHeap.remove();
            maxScore = Math.max(maxScore, sum * list.get(i)[1]);
        }
        
        return maxScore;
    }
}