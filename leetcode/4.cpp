#include <vector>
#include <iostream>
#include <algorithm>
using namespace std;

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size();
        int n = nums2.size();
        if (m > n)
            return findMedianSortedArrays(nums2, nums1);
        
        int start = 0;
        int end = m;
        int MAX_VAL = 1000001;
        int MIN_VAL = -1000001;

        while (start <= end) {
            int idxA = (start + end) / 2;
            int idxB = (m + n) / 2 - idxA;

            int leftA = idxA == 0 ? MIN_VAL : nums1[idxA-1];
            int rightA = idxA == m ? MAX_VAL : nums1[idxA];
            int leftB = idxB == 0 ? MIN_VAL : nums2[idxB-1];
            int rightB = idxB == n ? MAX_VAL : nums2[idxB];

            if (leftA <= rightB && leftB <= rightA) {
                return (m + n) % 2 ? min(rightA, rightB) : (max(leftA, leftB) + min(rightA, rightB)) / 2.0;
            } else if (leftA > rightB) {
                end = idxA;
            } else {
                start = idxA + 1;
            }
        }

        return 0;
    }
};

int main() {
    vector<int> nums1 {1, 3, 5, 7, 9};
    vector<int> nums2 {2, 4, 6, 8, 10};

    Solution sol;
    cout << "Result: " << sol.findMedianSortedArrays(nums1, nums2) << "\n";
}