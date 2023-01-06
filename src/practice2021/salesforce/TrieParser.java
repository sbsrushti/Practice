package practice2021.salesforce;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TrieParser {

    Trie trie;

    TrieParser(Map<Character, String> patternMap, List<String> dictonaryWords) {
        this.trie = new Trie(patternMap, dictonaryWords);
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
        int min = Math.abs(minWord.len - codeLen);

        for (int i = 1; i < words.size(); i++) {
            if (min > Math.abs(words.get(i).len - codeLen)) {
                minWord = words.get(i);
                min = Math.abs(minWord.len - codeLen);
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

            if (parentNode.children[patVal] == null) {
                return;
            }

            TrieNode currNode = parentNode.children[patVal];

            if (index == code.length()-1) {
                if (!currNode.isCharEnd || !currNode.isWordEnd) {
                    findNextGreaterWord(trieParserOutput, currNode, index);
                    return;
                }
                else {
                    trieParserOutput.matchedWords.addAll(currNode.words);
                }
                return;
            }

            if (currNode.isCharEnd) {

                if (currNode.isWordEnd) {
                    for (String word: currNode.words) {
                        trieParserOutput.longestPrefixWords.add(
                                new TrieParserOutput.MisMatchNode(word, index));
                    }
                }
            }

            parentNode = currNode;
            index++;
        }
    }

    private boolean findNextGreaterWord(TrieParserOutput trieParserOutput,
                                        TrieNode parentNode, int len) {

        if (parentNode.children[0] != null) {
            TrieNode currNode = parentNode.children[0];
            if (currNode.isCharEnd) {
                if (currNode.isWordEnd) {

                    for (String word: currNode.words) {
                        trieParserOutput.fewestExtraWords.add(
                                new TrieParserOutput.MisMatchNode(word, len));
                    }
                    return true;
                }
            }

            if (findNextGreaterWord(trieParserOutput, currNode, len+1)) return true;
        }

        if (parentNode.children[1] != null) {
            TrieNode currNode = parentNode.children[1];
            if (currNode.isCharEnd) {
                if (currNode.isWordEnd) {
                    for (String word: currNode.words) {
                        trieParserOutput.fewestExtraWords.add(
                                new TrieParserOutput.MisMatchNode(word, len));
                    }
                    return true;
                }
            }
            return findNextGreaterWord(trieParserOutput, currNode, len+1);
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
            int len;

            MisMatchNode(String word, int len) {
                this.word = word;
                this.len = len;
            }
        }
    }
}
