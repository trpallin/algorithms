class Solution {
    public int maxOperations(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            int complement = k - nums[i];
            if (map.containsKey(complement)) {
                count++;
                if (map.get(complement) == 1) {
                    map.remove(complement);                    
                } else {
                    map.put(complement, map.get(complement) - 1);
                }
            } else {
                map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
            }
        }
        return count;
    }
}