class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m = matrix.size();
        int n = matrix[0].size();
        
        int start = 0;
        int end = m - 1;
        int mid;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (matrix[mid][0] > target) {
                end = mid - 1;
            } else if (matrix[mid][n-1] >= target) {
                break;
            } else {
                start = mid + 1;
            }
        }

        int row = mid;

        start = 0;
        end = n - 1;

        while (start <= end) {
            mid = start + (end - start) / 2;

            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return false;
    }
};