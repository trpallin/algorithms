class Solution {
    public String mergeAlternately(String word1, String word2) {
        int idxA = 0, idxB = 0;
        StringBuilder sb = new StringBuilder();
        while (idxA < word1.length() && idxB < word2.length()) {
            sb.append(word1.charAt(idxA));
            sb.append(word2.charAt(idxB));
            idxA++;
            idxB++;
        }
        if (idxA < word1.length()) {
            sb.append(word1.substring(idxA));
        } else {
            sb.append(word2.substring(idxB));
        }
        return sb.toString();
    }
}