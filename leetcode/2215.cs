public class Solution {
    public IList<IList<int>> FindDifference(int[] nums1, int[] nums2) {
        ISet<int> set1 = new HashSet<int>(nums1);
        ISet<int> set2 = new HashSet<int>(nums2);
        IList<int> dist1 = set1.Except(set2).ToList();
        IList<int> dist2 = set2.Except(set1).ToList();
        return new List<IList<int>> { dist1, dist2 };
    }
}