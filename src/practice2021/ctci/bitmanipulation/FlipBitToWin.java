package practice2021.ctci.bitmanipulation;

public class FlipBitToWin {

    public static void main(String[] args) {

        //int m = 1775;
        int m = 55;
        ConvertToBinary convertToBinary = new ConvertToBinary();
        convertToBinary.toBinary(m);
        System.out.println(flip(m));
    }

    private static int flip(int m) {

        int i = 0;
        int sum = 0;
        int sum_additional = 0;
        int max = Integer.MIN_VALUE;
        boolean foundZeroAlready = false;

        while (i < 32) {
            int bitValue = getBit(m, i);
            if (bitValue == 0) {
                if (foundZeroAlready) {
                    if (max < sum) {
                        max = sum;
                        sum = sum_additional;
                    }
                } else {
                    sum++;
                    foundZeroAlready = true;
                }
            } else {
                if (foundZeroAlready)
                    sum_additional++;
                sum++;
            }
            i++;
        }
        return max;
    }

    private static int getBit(int n, int x) {
        return (n & (1 << x)) == 0 ? 0 : 1;
    }
}
