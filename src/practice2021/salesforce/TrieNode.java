package practice2021.salesforce;

import java.util.ArrayList;
import java.util.List;

public class TrieNode {

    boolean isCharEnd;
    boolean isWordEnd;
    List<String> words;
    TrieNode[] children;

    TrieNode() {
        this.isCharEnd = false;
        this.isWordEnd = false;
        this.children = new TrieNode[2]; // 0th index is dit(.), 1st index is dat(-)
        this.words = new ArrayList<>();
    }
}
