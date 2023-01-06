package practice.microsoft;

public class AQMaxChunksToSortArray {

    public static void main(String[] args) {

        int[] A = new int[] {2, 4, 1, 6, 3, 5, 9, 7};
//        int[] A = new int[] {4, 3, 2, 6, 1};
//        int[] A = new int[] {2, 1, 6, 4, 3, 7};

        if (A.length == 1 || A.length == 2) {
            System.out.println(1);
            return;
        }

        int max = Math.max(A[0], A[1]);
        int count = 0;

        for(int i = 1; i < A.length-1; i++) {
            if (A[i] > max) max = A[i];
            boolean check = true;
            for (int j = i+1; j < A.length; j++) {
                if (A[j] < max) {
                    check = false;
                    break;
                }
            }
            if (check) {
                count++;
                if (i < A.length-3) {
                    max = Math.max(A[ i + 1 ], A[ i + 2 ]);
                    i = i + 1;
                } else {
                    count++;
                    break;
                }
            }
        }
        if (count == 0) count = 1;
        System.out.println(count);
    }
}
