/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
void solve(int *nums, int numsSize, int start, int idx, int *cur, int *returnSize, int **returnColumnSizes, int **ans) {
    if (start == numsSize) return;

    solve(nums, numsSize, start + 1, idx, cur, returnSize, returnColumnSizes, ans);
    cur[idx++] = nums[start];
    ans[*returnSize] = (int*)malloc(idx * sizeof(int));
    for (int i = 0; i < idx; i++) {
        ans[*returnSize][i] = cur[i];
    }
    (*returnColumnSizes)[*returnSize] = idx;
    (*returnSize)++;
    solve(nums, numsSize, start + 1, idx, cur, returnSize, returnColumnSizes, ans);
}

int** subsets(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
    int n = 1 << numsSize;
    int **ans = (int**)malloc(n * sizeof(int*));
    *ans = (int*)malloc(sizeof(int));
    *returnSize = 1;
    *returnColumnSizes = (int*)malloc(n * sizeof(int*));
    (*returnColumnSizes)[0] = 0;
    int *cur = (int*)malloc(numsSize * sizeof(int*));
    solve(nums, numsSize, 0, 0, cur, returnSize, returnColumnSizes, ans);
    free(cur);
    return ans;
}