import java.util.*;

public class ArrayTransformation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        int K = sc.nextInt();

        // Step 1: Check if possible
        for (int i = 1; i < N; i++) {
            if ((A[i] - A[0]) % K != 0) {
                System.out.println(-1);
                return;
            }
        }

        // Step 2: Normalize the array
        int[] B = new int[N];
        for (int i = 0; i < N; i++) {
            B[i] = A[i] / K;
        }

        // Step 3: Sort
        Arrays.sort(B);

        // Step 4: Find median
        int median = B[N / 2];

        // Step 5: Count operations
        long operations = 0;
        for (int i = 0; i < N; i++) {
            operations += Math.abs(B[i] - median);
        }

        System.out.println(operations);
    }
}