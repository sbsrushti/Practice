package practice2021.salesforce;

import org.junit.Assert;
import org.junit.Before;
import org.junit.*;
import org.junit.runner.JUnitCore;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    MorseCode morseCodeTest;

    public static void main(String[] args) throws IOException {

        String fileName = args.length == 0 ? "src/practice2021/salesforce/input.txt" : args[0];
        MorseCode morseCode = new MorseCode(fileName);

        List<String> inputQuery = morseCode.inputParser.inputQueryStrings;

        List<String> result = new ArrayList<>();
        for (String input: inputQuery) {
            result.add(morseCode.trieParser.decodeMorseCode(input));
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/practice2021/salesforce/output.txt"))) {
            for (String decoded : result)
                writer.write(decoded + "\n");
        }

        JUnitCore.main(args);
//        Tester.testParse(morseCode, ".--.....--", "WHA");
//        Tester.testParse(morseCode, ".--.....--", "WHAT");
    }

    @Before
    public void setup() {
        morseCodeTest = new MorseCode("src/practice2021/salesforce/input.txt");
    }

    @Test
    public void testParse() {
        Assert.assertEquals("WHAT", morseCodeTest.trieParser.decodeMorseCode(".--.....--"));
    }

    static class Tester {

        static void testParse(MorseCode morseCode, String code, String expectedDecodedValue) {
            try {
                String actualDecodedValue = morseCode.trieParser.decodeMorseCode(code);

                if (!expectedDecodedValue.equals(actualDecodedValue))
                    throw new Exception("Value not correct");
                else
                    System.out.println("Test case testParse passed!");
            } catch (Exception ex) {
                System.out.println("Test case testParse failed!");
                ex.printStackTrace();
            }
        }
    }
}

class MorseCode {

    InputFileParser inputParser;
    TrieParser trieParser;

    public MorseCode (String input) {
        try {
            this.inputParser = new InputFileParser(input);
            this.trieParser = new TrieParser(this.inputParser.patternMap,
                    this.inputParser.dictionaryWords);
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }
}
