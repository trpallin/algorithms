/**
 * Return an array of arrays of size *returnSize.
 * The sizes of the arrays are returned as *returnColumnSizes array.
 * Note: Both returned array and *columnSizes array must be malloced, assume caller calls free().
 */
void solve(int **ans, int *cur, int start, int size, int n, int k, int *returnSize, int **returnColumnSizes) {
    if (size == k) {
        ans[*returnSize] = (int*)malloc(k * sizeof(int));
        for (int i = 0; i < k; i++) {
            ans[*returnSize][i] = cur[i];
        }
        (*returnColumnSizes)[*returnSize] = k;
        (*returnSize)++;
        return;
    }
    for (int i = start; i <= n; i++) {
        cur[size] = i;
        solve(ans, cur, i + 1, size + 1, n, k, returnSize, returnColumnSizes);
    }
}

int** combine(int n, int k, int* returnSize, int** returnColumnSizes) {
    int maxSize = 1;
    for (int i = 0; i < k; i++) {
        maxSize *= (n - i);
        maxSize /= (i + 1);
    }
    int **ans = (int**)malloc(maxSize * sizeof(int*));
    *returnColumnSizes = (int*)malloc(maxSize * sizeof(int));
    *returnSize = 0;
    int *cur = (int*)malloc(k * sizeof(int));
    solve(ans, cur, 1, 0, n, k, returnSize, returnColumnSizes);
    free(cur);

    return ans;
}