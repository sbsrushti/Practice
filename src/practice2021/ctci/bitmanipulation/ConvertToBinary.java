package practice2021.ctci.bitmanipulation;

import java.util.ArrayList;
import java.util.List;

public class ConvertToBinary {

    public String toBinary(int m) {
        List<Character> characterList = new ArrayList<>();
        while (m != 0) {
            char ch;
            if (m % 2 == 0)
                ch = '0';
            else
               ch = '1';
            characterList.add(0, ch);
            m = m/2;
        }
        String str = characterList.toString();
        System.out.println(str);
        return str;
    }
}
