class Solution {
    private boolean isOverlapping(int[] i1, int[] i2) {
        return (i1[0] <= i2[0] && i1[1] >= i2[0]) || (i1[0] <= i2[1] && i1[1] >= i2[1]) || (i1[0] <= i2[0] == i1[1] >= i2[1]);
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> ans = new ArrayList<>();
        int n = intervals.length;
        int mergeStartIdx = -1;
        for (int i = 0; i < n; ++i) {
            if (isOverlapping(intervals[i], newInterval)) {
                mergeStartIdx = i;
                break;
            }
        }
        
        if (mergeStartIdx >= 0) {
            int mergeEndIdx = mergeStartIdx;
            for (int i = mergeStartIdx + 1; i < n; ++i) {
                if (isOverlapping(intervals[i], newInterval)) {
                    mergeEndIdx = i;
                } else if (intervals[i][0] > newInterval[1]) {
                    break;
                }
            }
            for (int i = 0; i < mergeStartIdx; ++i) {
                ans.add(new int[] { intervals[i][0], intervals[i][1]});
            }
            int start = Math.min(intervals[mergeStartIdx][0], newInterval[0]);
            int end = Math.max(intervals[mergeEndIdx][1], newInterval[1]);
            ans.add(new int[] { start, end });
            for (int i = mergeEndIdx + 1; i < n; ++i) {
                ans.add(new int[] { intervals[i][0], intervals[i][1]});
            }
        } else {
            int[] starts = new int[n];
            for (int i = 0; i < n; ++i) {
                starts[i] = intervals[i][0];
            }
            int idx = Arrays.binarySearch(starts, newInterval[0]);
            if (idx < 0) {
                idx = -idx - 1;
            }
            for (int i = 0; i < idx; ++i) {
                ans.add(new int[] { intervals[i][0], intervals[i][1]});
            }
            ans.add(new int[] { newInterval[0], newInterval[1]});
            for (int i = idx; i < n; ++i) {
                ans.add(new int[] { intervals[i][0], intervals[i][1]});
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}