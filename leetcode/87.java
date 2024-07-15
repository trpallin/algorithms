class Solution {
    Map<String, Boolean> dp = new HashMap<>();

    public boolean isScramble(String s1, String s2) {
        if (s1.equals(s2)) {
            return true;
        }
        String key = s1 + s2;
        if (dp.containsKey(key)) {
            return dp.get(key);
        }
        int len = s1.length();

        int[] s1Count = new int[26];
        int[] s2Count = new int[26];
        int[] s1ReverseCount = new int[26];

        for (int i = 0; i < len; ++i) {
            s1Count[s1.charAt(i) - 'a']++;
            s2Count[s2.charAt(i) - 'a']++;
        }

        if (!Arrays.equals(s1Count, s2Count)) {
            dp.put(key, false);
            return false;
        }

        for (int i = 1; i < len; ++i) {
            String s1Left = s1.substring(0, i);
            String s1Right = s1.substring(i);
            String s1ReverseLeft = s1.substring(len - i);
            String s1ReverseRight = s1.substring(0, len - i);

            String s2Left = s2.substring(0, i);
            String s2Right = s2.substring(i);            

            if (isScramble(s1Left, s2Left) && isScramble(s1Right, s2Right)) {
                dp.put(key, true);
                return true;
            }
            if (isScramble(s1ReverseLeft, s2Left) && isScramble(s1ReverseRight, s2Right)) {
                dp.put(key, true);
                return true;
            }
        }
        dp.put(key, false);
        return false;
    }
}