class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            countMap.put(arr[i], countMap.getOrDefault(arr[i], 0) + 1);
        }
        Set<Integer> occurrenceSet = new HashSet<>();
        for (int n : countMap.values()) {
            if (occurrenceSet.contains(n)) {
                return false;
            } else {
                occurrenceSet.add(n);
            }
        }
        return true;
    }
}