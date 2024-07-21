class Solution {
    public int[][] merge(int[][] intervals) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for (int[] interval : intervals) {
            min = Math.min(min, interval[0]);
            max = Math.max(max, interval[1]);
        }

        int[] intervalTo = new int[max - min + 1];

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];
            intervalTo[start - min] = Math.max(intervalTo[start - min], end - min);
        }

        List<int[]> ans = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < intervalTo.length; ++i) {
            if (intervalTo[i] == 0) continue;

            if (i <= end) {
                end = Math.max(intervalTo[i], end);
            } else {
                ans.add(new int[] { start + min, end + min });
                start = i;
                end = intervalTo[i];
            }
        }

        ans.add(new int[] { start + min, end + min });

        return ans.toArray(new int[ans.size()][]);
    }
}