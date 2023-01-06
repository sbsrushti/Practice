package practice2021.ctci.bitmanipulation;

public class NextNumberWithSameBits {

    public static void main(String[] args) {

        int num = 20;
        ConvertToBinary convertToBinary = new ConvertToBinary();
        convertToBinary.toBinary(num);
        int highest = nextHighest(num);
        int lowest = nextLowest(num);
        System.out.printf("Next highest: %s, %s\n", highest, convertToBinary.toBinary(highest));
        System.out.printf("Next Lowest: %s, %s\n", lowest, convertToBinary.toBinary(lowest));
    }

    private static int nextHighest(int num) {
        int i = 0;
        int prevBit = -1;
        while (i < 32) {
            int bitValue = getBit(num, i);
            if (bitValue == 0) {
                if (prevBit == 1) {
                    num = setBit(num, i-1, 0);
                    num = setBit(num, i, 1);
                    break;
                }
            }
            i++;
            prevBit = bitValue;
        }
        if (prevBit == -1) return prevBit;
        return num;
    }

    private static int nextLowest(int num) {
        int i = 0;
        int prevBit = -1;
        while (i < 32) {
            int bitValue = getBit(num, i);
            if (bitValue == 1) {
                if (prevBit == 0) {
                    num = setBit(num, i-1, 1);
                    num = setBit(num, i, 0);
                    break;
                }
            }
            i++;
            prevBit = bitValue;
        }
        if (prevBit == -1) return prevBit;
        return num;
    }


    private static int getBit(int m, int i) {
        return (m & (1 << i)) == 0? 0 : 1;
    }

    private static int setBit(int m, int i, int bitValue) {
        if (bitValue == 1) {
            return m | (1 << i);
        } else {
            return m & (~(1 << i));
        }
    }
}
