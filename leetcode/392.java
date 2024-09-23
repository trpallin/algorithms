class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }
        int idxS = 0;
        for (int i = 0; i < t.length(); i++) {
            if (s.charAt(idxS) == t.charAt(i) && ++idxS >= s.length()) {
                return true;
            }
        }
        return false;
    }
}