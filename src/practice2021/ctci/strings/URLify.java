package practice2021.ctci.strings;

import java.util.Arrays;

public class URLify {

    public static void main(String[] args) {

        //char[] char_arr = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
        char[] char_arr = {'M', 'r', ' ', 'J', 'o', 'h', 'n', ' ', 'S', 'm', 'i', 't', 'h', ' ', ' ', ' ', ' '};

        //char[] char_arr = {'a', ' ', ' ', ' ', ' ', ' ', ' '};
        char[] replacement_arr = {'%', '2', '0'};
        int trueLength = 13;
        inPlaceReplacement(char_arr, replacement_arr, trueLength);
        printCharArr(char_arr);
    }

    private static void inPlaceReplacement(char[] char_arr, char[] replacement_arr, int trueLength) {

        if (char_arr.length == 0)
            System.out.println("");

        int read_index = trueLength - 1;
        int write_index = char_arr.length - 1;

        while (read_index != write_index) { //we need not go till read_index == 0
            if (char_arr[read_index] == ' ') {
                for (int j = replacement_arr.length-1; j >=0; j--) {
                    char_arr[write_index] = replacement_arr[j];
                    write_index--;
                }
            } else {
                char_arr[write_index] = char_arr[read_index];
                write_index--;
            }
            read_index--;
        }
    }

    private static void printCharArr(char[] arr) {
        for (char c : arr) System.out.print(c);
    }
}
