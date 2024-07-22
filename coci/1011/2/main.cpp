#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    int N;
    cin >> N;

    int studentCounts[6] = {0};
    int maxNumOfStudents[6] = {0};

    for (int i = 0; i < N; ++i) {
        int left, right;
        cin >> left >> right;

        for (int j = 1; j <= 5; ++j) {
            if (left == j || right == j) {
                maxNumOfStudents[j] = max(maxNumOfStudents[j], ++studentCounts[j]);
            } else {
                studentCounts[j] = 0;
            }
        }
    }

    int maxNum = 0;
    int grade = 0;

    for (int i = 1; i <= 5; ++i) {
        if (maxNumOfStudents[i] > maxNum) {
            maxNum = maxNumOfStudents[i];
            grade = i;
        }
    }

    cout << maxNum << " " << grade << endl;

    return 0;
}