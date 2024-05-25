class Solution {
public:
    int trap(vector<int>& height) {
        int left = 0;
        int right = height.size() - 1;
        int currentMaxHeight = 0;
        int waterAmount = 0;
        
        while (left < right) {
            if (min(height[left], height[right]) > currentMaxHeight) {
                if (height[left] < height[right]) {
                    currentMaxHeight = height[left++];
                } else {
                    currentMaxHeight = height[right--];
                }
            } else {
                if (height[left] < height[right]) {
                    waterAmount += currentMaxHeight - height[left++];
                } else {
                    waterAmount += currentMaxHeight - height[right--];
                }
            }
        }
        return waterAmount;
    }
};