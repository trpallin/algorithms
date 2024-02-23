#include <iostream>
#include <cmath>
using namespace std;

class Cell {
public:
    bool horizontal = false;
    bool vertical = false;
};

int main() {
    ios::sync_with_stdio(false); cin.tie(0); cout.tie(0);

    int T, N, W;
    int j;

    cin >> T;

    int *ans = new int[T];

    for (int i = 0; i < T; i++) {
        cin >> N >> W;
        int numEnemy[2*N];

        for (j = 0; j < N; j++) {
            cin >> numEnemy[j];
        }

        for (j = 0; j < N; j++) {
            cin >> numEnemy[N + j];
        }

        int numOf2;
        int maxNumOf2 = 0;
        int s_upleft, s_downleft, s_up, s_down;
        Cell c_upleft, c_downleft;

        int offset = 0;

        while (offset < 2) {
            // cout << "\nwhile offset: " << offset << "\n";
            s_up = numEnemy[offset];
            s_down = numEnemy[N+offset];

            numOf2 = 0;

            // init
            if (s_up + s_down <= W) {
                c_upleft.horizontal = false;
                c_downleft.horizontal = false;
                c_upleft.vertical = true;
                c_downleft.vertical = true;

                numOf2++;
                // cout << "\tcase: " << 0 << "\n";
            } else {
                c_upleft.horizontal = false;
                c_downleft.horizontal = false;
                c_upleft.vertical = false;
                c_downleft.vertical = false;
            }

//
            for (int j = 1+offset; j < N+offset; j++) {
                // cout << "j: " << j << "\n";
                s_upleft = s_up;
                s_downleft = s_down;
                if (offset > 0 && j == N) {
                    s_up = numEnemy[0];
                    s_down = numEnemy[N];
                } else {
                    s_up = numEnemy[j];
                    s_down = numEnemy[j + N];
                }

                if (c_upleft.horizontal) {
                    if (c_downleft.horizontal) { // HH
                        if (s_up + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = true;
                            c_upleft.vertical = true;
                            numOf2++;
                            // cout << "\tcase: " << 1 << "\n";
                        } else {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        }
                    } else { // H_
                        if (s_downleft + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = true;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                            numOf2++;
                            // cout << "\tcase: " << 2 << "\n";
                        } else if (s_up + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = true;
                            c_upleft.vertical = true;
                            numOf2++;
                            // cout << "\tcase: " << 3 << "\n";
                        } else {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        }
                    }
                } else if (c_upleft.vertical) { // VV
                    if (s_up + s_down <= W) {
                        c_upleft.horizontal = false;
                        c_downleft.horizontal = false;
                        c_upleft.vertical = true;
                        c_upleft.vertical = true;
                        numOf2++;
                        // cout << "\tcase: " << 4 << "\n";
                    } else if (s_upleft + s_up <= W && s_downleft + s_down <= W) {
                        c_upleft.horizontal = true;
                        c_downleft.horizontal = true;
                        c_upleft.vertical = false;
                        c_upleft.vertical = false;
                        numOf2++;
                        // cout << "\tcase: " << 5 << "\n";
                    } else {
                        c_upleft.horizontal = false;
                        c_downleft.horizontal = false;
                        c_upleft.vertical = false;
                        c_upleft.vertical = false;
                    }
                } else {
                    if (c_downleft.horizontal) { // _H
                        if (s_upleft + s_up <= W) {
                            c_upleft.horizontal = true;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                            numOf2++;
                            // cout << "\tcase: " << 6 << "\n";
                        } else if (s_up + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = true;
                            c_upleft.vertical = true;
                            numOf2++;
                            // cout << "\tcase: " << 7 << "\n";
                        } else {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        }
                    } else { // __
                        if (s_upleft + s_up <= W || s_downleft + s_down <= W) {
                            if (s_upleft + s_up <= W) {
                                c_upleft.horizontal = true;
                                numOf2++;
                                // cout << "\tcase: " << 8 << "\n";
                            } else {
                                c_upleft.horizontal = false;
                            }
                            if (s_downleft + s_down <= W) {
                                c_downleft.horizontal = true;
                                numOf2++;
                                // cout << "\tcase: " << 9 << "\n";
                            } else {
                                c_downleft.horizontal = false;
                            }
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        } else if (s_up + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = true;
                            c_upleft.vertical = true;
                            numOf2++;
                            // cout << "\tcase: " << 10 << "\n";
                        } else {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        }
                    }

                }
            }

            // cout << "numOf2 : " << numOf2 << "\n";
            maxNumOf2 = max(numOf2, maxNumOf2);

            offset++;
        }

        offset = 0;

        while (offset < 2) {
            // cout << "\nwhile 2 offset: " << offset << "\n";
            numOf2 = 0;

            if (offset > 0) { // second line indented
                s_up = numEnemy[N+1];
                s_down = numEnemy[1];

                if (numEnemy[0] + numEnemy[1] <= W) {
                    c_upleft.horizontal = false;
                    c_downleft.horizontal = true;
                    c_upleft.vertical = false;
                    c_upleft.vertical = false;
                    // cout << "\tcase: " << -1 << "\n";
                    numOf2++;
                } else if (numEnemy[1] + numEnemy[N+1] <= W) {
                    c_upleft.horizontal = false;
                    c_downleft.horizontal = false;
                    c_upleft.vertical = true;
                    c_upleft.vertical = true;
                    // cout << "\tcase: " << -2 << "\n";
                    numOf2++;
                } else {
                    c_upleft.horizontal = false;
                    c_downleft.horizontal = false;
                    c_upleft.vertical = false;
                    c_upleft.vertical = false;
                }
            } else { // first line indented
                s_up = numEnemy[1];
                s_down = numEnemy[N+1];

                if (numEnemy[N] + numEnemy[N+1] <= W) {
                    c_upleft.horizontal = false;
                    c_downleft.horizontal = true;
                    c_upleft.vertical = false;
                    c_upleft.vertical = false;
                    // cout << "\tcase: " << -3 << "\n";
                    numOf2++;
                } else if (numEnemy[1] + numEnemy[N+1] <= W) {
                    c_upleft.horizontal = false;
                    c_downleft.horizontal = false;
                    c_upleft.vertical = true;
                    c_upleft.vertical = true;
                    // cout << "\tcase: " << -4 << "\n";
                    numOf2++;
                } else {
                    c_upleft.horizontal = false;
                    c_downleft.horizontal = false;
                    c_upleft.vertical = false;
                    c_upleft.vertical = false;
                }
            }
            
            


            for (int j = 2; j < N; j++) {
                // cout << "j: " << j << "\n";
                s_upleft = s_up;
                s_downleft = s_down;
                if (offset > 0) {
                    s_up = numEnemy[j+N];
                    s_down = numEnemy[j];
                } else {
                    s_up = numEnemy[j];
                    s_down = numEnemy[j+N];
                }

                if (c_upleft.horizontal) {
                    if (c_downleft.horizontal) { // HH
                        if (s_up + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = true;
                            c_upleft.vertical = true;
                            numOf2++;
                            // cout << "\tcase: " << 1 << "\n";
                        } else {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        }
                    } else { // H_
                        if (s_downleft + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = true;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                            numOf2++;
                            // cout << "\tcase: " << 2 << "\n";
                        } else if (s_up + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = true;
                            c_upleft.vertical = true;
                            numOf2++;
                            // cout << "\tcase: " << 3 << "\n";
                        } else {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        }
                    }
                } else if (c_upleft.vertical) { // VV
                    if (s_up + s_down <= W) {
                        c_upleft.horizontal = false;
                        c_downleft.horizontal = false;
                        c_upleft.vertical = true;
                        c_upleft.vertical = true;
                        numOf2++;
                        // cout << "\tcase: " << 4 << "\n";
                    } else if (s_upleft + s_up <= W && s_downleft + s_down <= W) {
                        c_upleft.horizontal = true;
                        c_downleft.horizontal = true;
                        c_upleft.vertical = false;
                        c_upleft.vertical = false;
                        numOf2++;
                        // cout << "\tcase: " << 5 << "\n";
                    } else {
                        c_upleft.horizontal = false;
                        c_downleft.horizontal = false;
                        c_upleft.vertical = false;
                        c_upleft.vertical = false;
                    }
                } else {
                    if (c_downleft.horizontal) { // _H
                        if (s_upleft + s_up <= W) {
                            c_upleft.horizontal = true;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                            numOf2++;
                            // cout << "\tcase: " << 6 << "\n";
                        } else if (s_up + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = true;
                            c_upleft.vertical = true;
                            numOf2++;
                            // cout << "\tcase: " << 7 << "\n";
                        } else {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        }
                    } else { // __
                        if (s_upleft + s_up <= W || s_downleft + s_down <= W) {
                            if (s_upleft + s_up <= W) {
                                c_upleft.horizontal = true;
                                numOf2++;
                                // cout << "\tcase: " << 8 << "\n";
                            } else {
                                c_upleft.horizontal = false;
                            }
                            if (s_downleft + s_down <= W) {
                                c_downleft.horizontal = true;
                                numOf2++;
                                // cout << "\tcase: " << 9 << "\n";
                            } else {
                                c_downleft.horizontal = false;
                            }
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        } else if (s_up + s_down <= W) {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = true;
                            c_upleft.vertical = true;
                            numOf2++;
                            // cout << "\tcase: " << 10 << "\n";
                        } else {
                            c_upleft.horizontal = false;
                            c_downleft.horizontal = false;
                            c_upleft.vertical = false;
                            c_upleft.vertical = false;
                        }
                    }

                }

            }

            s_upleft = s_up;
            s_downleft = s_down;

            if (offset > 0) {
                s_up = numEnemy[N];
                s_down = numEnemy[0];
            } else {
                s_up = numEnemy[0];
                s_down = numEnemy[N];
            }

            if (c_upleft.horizontal) {
                // do nothing
            } else if (c_upleft.vertical) {
                // do nothing
            } else {
                if (s_upleft + s_up <= W) {
                    numOf2++;
                    // cout << "\tcase: " << 11 << "\n";
                }
            }


            // cout << "numOf2 : " << numOf2 << "\n";
            maxNumOf2 = max(numOf2, maxNumOf2);

            offset++;
        }



        
        ans[i] = 2*N - maxNumOf2;
    }

    for (int i = 0; i < T; i++) {
        cout << ans[i] << "\n";
    }

    return 0;
}