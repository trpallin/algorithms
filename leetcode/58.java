class Solution {
    public int lengthOfLastWord(String s) {
        int idx = s.length() - 1;
        int count = 0;
        while (s.charAt(idx) == ' ')
            idx--;
        while (idx >= 0 && s.charAt(idx) != ' ') {
            idx--;
            count++;
        }
        return count;
    }
}