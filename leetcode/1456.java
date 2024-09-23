class Solution {
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public int maxVowels(String s, int k) {
        int vowelNum = 0;
        for (int i = 0; i < k; i++) {
            if (isVowel(s.charAt(i))) {
                vowelNum++;
            }
        }
        int maxVowels = vowelNum;
        for (int i = k; i < s.length(); i++) {
            if (isVowel(s.charAt(i - k))) {
                vowelNum--;
            }
            if (isVowel(s.charAt(i))) {
                vowelNum++;
            }
            if (vowelNum > maxVowels) {
                maxVowels = vowelNum;
            }
        }
        return maxVowels;
    }
}