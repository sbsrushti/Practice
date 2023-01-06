package practice2021.salesforce;

import java.util.List;
import java.util.Map;

public class Trie {

    TrieNode root;

    Trie(Map<Character, String> patternMap, List<String> dictonaryWords) {
        this.root = new TrieNode();
        buildTree(patternMap, dictonaryWords);
    }

    private void buildTree(Map<Character, String> patternMap, List<String> dictonaryWords) {
        for (String word : dictonaryWords) {
            addWord(word, patternMap);
        }
    }

    private void addWord(String word, Map<Character, String> patternMap) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            node = addCharacter(word.charAt(i),
                    patternMap.get(word.charAt(i)), node);
        }

        node.isWordEnd = true;
        node.words.add(word);
    }

    private TrieNode addCharacter(char character, String pattern, TrieNode parentNode) {

        int index = 0;

        while (index < pattern.length()) {
            int patVal = pattern.charAt(index) == '.' ? 0 : 1;

            if (parentNode.children[patVal] == null) {
                parentNode.children[patVal] = new TrieNode();
            }

            TrieNode currNode = parentNode.children[patVal];

            if (!currNode.isCharEnd) {
                currNode.isCharEnd = index == pattern.length() - 1;
            }

            parentNode = currNode;
            index++;
        }

        return parentNode;
    }
}

