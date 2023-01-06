package practice.microsoft;

public class AOFairIndices {

    public static void main(String[] args) {

//        int[] arr1 = new int[] {4, -1, 0, 3};
//        int[] arr2 = new int[] {-2, 5, 0, 3};

//        int[] arr1 = new int[] {2, -2, -3, 3};
//        int[] arr2 = new int[] {0, 0, 4, -4};

//        int[] arr1 = new int[] {4, -1, 0, 3};
//        int[] arr2 = new int[] {-2, 6, 0, 4};

//        int[] arr1 = new int[] {3, 2, 6};
//        int[] arr2 = new int[] {4, 1, 6};

        int[] arr1 = new int[] {1, 4, 2, -2, 5};
        int[] arr2 = new int[] {7, -2, -2, 2, 5};

        int size = arr1.length;
        int sum1 = 0;
        int sum2 = 0;

        for (int i = 0; i < size; i++) {
            sum1 += arr1[i];
            sum2 += arr2[i];
        }
        int a = 0, b = sum1, c = 0, d = sum2;
        int count = 0;

        for (int i = 1; i < size; i++) {
            a = a + arr1[i-1];
            b = b - arr1[i-1];
            c = c + arr2[i-1];
            d = d - arr2[i-1];
            if (a == b && b == c && c == d) {
                count++;
            }
        }

        System.out.println(count);
    }
}
