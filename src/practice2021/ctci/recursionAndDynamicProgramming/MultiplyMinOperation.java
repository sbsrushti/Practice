package practice2021.ctci.recursionAndDynamicProgramming;

public class MultiplyMinOperation {

    public static void main(String[] args) {

        int m = 4;
        int n = 1;
        boolean isNEven = false;

        if (m == 1) {
            System.out.println(n);
            return;
        } else if (n == 1) {
            System.out.println(m);
            return;
        }
        int n_new = n >>> 1;
        if (n_new + n_new == n) {
            isNEven = true;
        }
        int res = m;

        while (n_new != 0) {
            res = res << 1;
            n_new--;
        }
        if (!isNEven) {
            res = res + m;
        }

        System.out.println(res);
    }
}
