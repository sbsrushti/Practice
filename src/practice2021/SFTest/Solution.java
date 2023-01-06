package practice2021.SFTest;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    /*
     * Complete the function below.
     */

    static void doIt(String[] input) {
        MorseCodeDecoder morseCodeDecoder = new MorseCodeDecoder(input);
        // System.out.println(morseCodeDecoder.inputParser.inputQueryCodes);
        // System.out.println(morseCodeDecoder.inputParser.dictionaryWords);
        // System.out.println(morseCodeDecoder.inputParser.morseCodeMapping);

        morseCodeDecoder.decode();
    }

    public static void main(String[] args) {

        String[] input = new String[55];

        try (BufferedReader bufferedFileReader = new BufferedReader(new FileReader("src/practice2021/salesforce/input.txt"))) {
            String line = bufferedFileReader.readLine();
            int i = 0;

            while (line != null) {
                input[i] = line;
                i++;
                line = bufferedFileReader.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error while parsing input file");
        }
        doIt(input);
    }
}

class MorseCodeDecoder {

    InputParser inputParser;
    TrieParser trieParser;

    public MorseCodeDecoder(String[] input) {
        this.inputParser = new InputParser(input);
        this.trieParser = new TrieParser(this.inputParser.morseCodeMapping, this.inputParser.dictionaryWords);
    }

    public void decode() {
        for (String inputCode: this.inputParser.inputQueryCodes) {
            System.out.println(this.trieParser.decodeMorseCode(inputCode));
        }
    }
}

class InputParser {

    Map<Character, String> morseCodeMapping;
    List<String> dictionaryWords;
    List<String> inputQueryCodes;
    String[] input;

    InputParser(String[] input) {
        this.morseCodeMapping = new HashMap<>();
        this.dictionaryWords = new ArrayList<>();
        this.inputQueryCodes = new ArrayList<>();
        this.input = input;
        parseInput();
    }

    private void parseInput() {
        int index = 0;
        index = populateMorseCodeMapping(index);
        index = populateDictWords(index);
        populateInputQueryCodes(index);
    }

    private int populateMorseCodeMapping(int index) {
        while (index < this.input.length) {
            String line = this.input[index].trim();
            if (line.equals("*")) return index+1;
            this.morseCodeMapping.put(line.charAt(0), line.substring(1).trim());
            index++;
        }
        return -1;
    }

    private int populateDictWords(int index) {
        while (index < this.input.length) {
            String line = this.input[index].trim();
            if (line.equals("*")) return index+1;
            this.dictionaryWords.add(line);
            index++;
        }
        return -1;
    }

    private void populateInputQueryCodes(int index) {

        while (index < this.input.length) {
            String line = this.input[index].trim();
            if (line.equals("*")) return;

            int spaceIndex = line.indexOf(" ");
            int startIndex = 0;

            while (startIndex < line.length() && spaceIndex != -1) {
                String partialString = line.substring(startIndex, spaceIndex).trim();

                if (!partialString.isEmpty())
                    this.inputQueryCodes.add(partialString);
                startIndex = spaceIndex + 1;
                spaceIndex = partialString.indexOf(" ", spaceIndex+1);
            }

            if (startIndex < line.length()) {
                String partialString = line.substring(startIndex).trim();
                if ( !partialString.isEmpty())
                    this.inputQueryCodes.add(partialString);
            }
            index++;
        }
    }
}

class TrieParser {

    Trie trie;

    TrieParser(Map<Character, String> morseCodeMapping, List<String> dictionaryWords) {
        this.trie = new Trie(morseCodeMapping, dictionaryWords);
    }

    public String decodeMorseCode(String code) {
        TrieParserOutput trieParserOutput = new TrieParserOutput();
        decode(code, trieParserOutput, trie.root);

        if (trieParserOutput.matchedWords.size() == 1)
            return trieParserOutput.matchedWords.get(0);

        if (trieParserOutput.matchedWords.size() > 0) {
            return minLenString(trieParserOutput.matchedWords) + "!";
        }

        trieParserOutput.longestPrefixWords.addAll(trieParserOutput.fewestExtraWords);
        String minMismatchNode = minMismatch(trieParserOutput.longestPrefixWords, code.length());

        if (minMismatchNode == null) return null;

        return minMismatchNode + "?";
    }

    private String minMismatch(List<TrieParserOutput.MisMatchNode> words, int codeLen) {

        if (words.isEmpty()) return null;

        TrieParserOutput.MisMatchNode minWord = words.get(0);
        int min = Math.abs(minWord.codeLen - codeLen);

        for (int i = 1; i < words.size(); i++) {
            if (min > Math.abs(words.get(i).codeLen - codeLen)) {
                minWord = words.get(i);
                min = Math.abs(minWord.codeLen - codeLen);
            }
        }

        return minWord.word;
    }

    private String minLenString(List<String> words) {

        if (words.isEmpty()) return null;

        String minWord = words.get(0);
        int min = minWord.length();

        for (int i = 1; i < words.size(); i++) {
            if (min > words.get(i).length()) {
                minWord = words.get(i);
                min = minWord.length();
            }
        }

        return minWord;
    }

    private void decode(String code,
                        TrieParserOutput trieParserOutput,
                        TrieNode parentNode) {

        int index = 0;
        while (index < code.length()) {

            char ch = code.charAt(index);
            int patVal = ch == '.' ? 0 : 1;

            if (parentNode.childrenNodes[patVal] == null) {
                return;
            }

            TrieNode currNode = parentNode.childrenNodes[patVal];

            if (index == code.length()-1) {
                if (!currNode.isWordEnd) {
                    findNextGreaterWord(trieParserOutput, currNode, index);
                    return;
                }
                else {
                    trieParserOutput.matchedWords.addAll(currNode.words);
                }
                return;
            }

            if (currNode.isWordEnd) {
                for (String word: currNode.words) {
                    trieParserOutput.longestPrefixWords.add(
                            new TrieParserOutput.MisMatchNode(word, index));
                }
            }

            parentNode = currNode;
            index++;
        }
    }

    private boolean findNextGreaterWord(TrieParserOutput trieParserOutput,
                                        TrieNode parentNode, int codeLen) {

        if (parentNode.childrenNodes[0] != null) {
            TrieNode currNode = parentNode.childrenNodes[0];
            if (currNode.isWordEnd) {

                for (String word: currNode.words) {
                    trieParserOutput.fewestExtraWords.add(
                            new TrieParserOutput.MisMatchNode(word, codeLen));
                }
                return true;
            }

            if (findNextGreaterWord(trieParserOutput, currNode, codeLen+1)) return true;
        }

        if (parentNode.childrenNodes[1] != null) {
            TrieNode currNode = parentNode.childrenNodes[1];
            if (currNode.isWordEnd) {
                for (String word: currNode.words) {
                    trieParserOutput.fewestExtraWords.add(
                            new TrieParserOutput.MisMatchNode(word, codeLen));
                }
                return true;
            }
            return findNextGreaterWord(trieParserOutput, currNode, codeLen+1);
        }

        return false;
    }

    static class TrieParserOutput {
        List<String> matchedWords;
        List<MisMatchNode> longestPrefixWords;
        List<MisMatchNode> fewestExtraWords;

        TrieParserOutput() {
            this.matchedWords = new ArrayList<>();
            this.longestPrefixWords = new ArrayList<>();
            this.fewestExtraWords = new ArrayList<>();
        }

        static class MisMatchNode {
            String word;
            int codeLen;

            MisMatchNode(String word, int codeLen) {
                this.word = word;
                this.codeLen = codeLen;
            }
        }
    }
}

class Trie {

    TrieNode root;
    Trie (Map<Character, String> morseCodeMapping, List<String> dictionaryWords) {
        this.root = new TrieNode();
        buildTree(dictionaryWords, morseCodeMapping);
    }

    private void buildTree(List<String> dictionaryWords, Map<Character, String> morseCodeMapping) {
        for (String word: dictionaryWords) {
            TrieNode node = root;
            for (int i = 0; i < word.length(); i++) {
                node = addCharacter(morseCodeMapping.get(word.charAt(i)), node);
            }
            node.isWordEnd = true;
            node.words.add(word);
        }
    }

    private TrieNode addCharacter(String pattern, TrieNode parentNode) {
        int index = 0;

        while (index < pattern.length()) {
            int patternValue = pattern.charAt(index) == '.' ? 0 : 1;

            if (parentNode.childrenNodes[patternValue] == null) {
                parentNode.childrenNodes[patternValue] = new TrieNode();
            }
            parentNode = parentNode.childrenNodes[patternValue];
            index++;
        }
        return parentNode;
    }
}

class TrieNode {

    boolean isWordEnd;
    List<String> words;
    TrieNode[] childrenNodes;

    TrieNode() {
        this.isWordEnd = false;
        this.childrenNodes = new TrieNode[2]; // 0th index is dit(.), 1st index is dat(-)
        this.words = new ArrayList<>();
    }
}
