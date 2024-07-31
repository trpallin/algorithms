void sortColors(int* nums, int numsSize) {
    int red = 0;
    int white = 0;

    for (int i = 0; i < numsSize; i++) {
        if (nums[i] == 0) {
            red++;
        } else if (nums[i] == 1){
            white++;
        }
    }
    int idx = 0;
    for (int i = 0; i < red; i++) {
        nums[i] = 0;
    }
    idx += red;
    for (int i = 0; i < white; i++) {
        nums[idx + i] = 1;
    }
    idx += white;
    for (int i = 0; i < numsSize - idx; i++) {
        nums[idx + i] = 2;
    }
}