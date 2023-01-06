package practice2021.ctci.treesandgraphs.tree;

import java.util.HashMap;

public class PrefixTrieNode {
    public Character content;
    public HashMap<Character, PrefixTrieNode> children;
    /**
     * Use PrefixTrieNode[] children = new PrefixTrieNode[256];
     */
    public boolean isWord = false;

    public PrefixTrieNode(Character content) {
        this.content = content;
        this.children = new HashMap<>();
    }
}
