import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M, N, K;
        M = sc.nextInt();
        N = sc.nextInt();
        K = sc.nextInt();
        if (M >= 2 * N + K) {
            System.out.println(N);
        } else if (M <= 2 * (N - K)) {
            System.out.println(M / 2);
        } else {
            int team = N - K;
            int leftGirls = M - 2 * (N - K);
            while (leftGirls >= 3) {
                team++;
                leftGirls -= 3;
            }
            System.out.println(team);
        }
        sc.close();
    }
}
