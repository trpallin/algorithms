public class Solution {
    public int LargestAltitude(int[] gain) {
        int alt = 0;
        int maxAlt = 0;
        for (int i = 0; i < gain.Length; i++) {
            alt += gain[i];
            maxAlt = Math.Max(maxAlt, alt);
        }
        return maxAlt;
    }
}