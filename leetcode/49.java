class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        List<List<String>> ans = new ArrayList<>();
        Map<String, List<String>> strMap = new HashMap<>();
        for (int i = 0; i < n; ++i) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String key = new String(temp);
            if (!strMap.containsKey(key)) {
                strMap.put(key, new ArrayList<>());
            }
            strMap.get(key).add(strs[i]);
        }
        return new ArrayList<>(strMap.values());
    }
}