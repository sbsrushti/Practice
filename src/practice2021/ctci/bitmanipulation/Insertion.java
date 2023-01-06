package practice2021.ctci.bitmanipulation;

public class Insertion {

    public static void main(String[] args) {

        int m = 100;
        int n = 3;
        ConvertToBinary convertToBinary = new ConvertToBinary();
        convertToBinary.toBinary(m);
        convertToBinary.toBinary(n);
        m = insert(m, n, 4, 3);
        convertToBinary.toBinary(m);
    }

    private static int insert(int m, int n, int i, int j) {
        int x = 0;
        while (j <= i) {
            int bitValue = getBit(n, x);
            m = setBit(m, bitValue, j);
            j++;
            x++;
        }
        return m;
    }

    private static int getBit(int n, int x) {
        return (n & (1 << x)) == 0 ? 0 : 1;
    }

    private static int setBit(int m, int bitValue, int i) {
        if (bitValue == 1) {
            return m | (1 << i);
        } else {
            return m & (~(1 << i));
        }
    }
}
