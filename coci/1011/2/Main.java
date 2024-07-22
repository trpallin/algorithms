import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();
        int[] studentCounts = new int[6];
        int[] maxNumOfStudents = new int[6];

        for (int i = 0; i < N; ++i) {
            int left = sc.nextInt();
            int right = sc.nextInt();
            sc.nextLine();

            for (int j = 1; j <= 5; ++j) {
                if (left == j || right == j) {
                    maxNumOfStudents[j] = Math.max(maxNumOfStudents[j], ++studentCounts[j]);
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

        System.out.println(maxNum + " " + grade);

        sc.close();
    }
}
