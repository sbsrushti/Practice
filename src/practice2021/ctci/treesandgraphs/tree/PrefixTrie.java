package practice2021.ctci.treesandgraphs.tree;

public class PrefixTrie {
    private PrefixTrieNode root;

    public PrefixTrie() {
        this.root = new PrefixTrieNode(null);
    }

    public void insert(String word) {
        PrefixTrieNode current = root;
        for (Character ch: word.toCharArray()) {
            if (current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else {
                PrefixTrieNode newNode = new PrefixTrieNode(ch);
                current.children.put(ch, newNode);
                current = newNode;
            }
        }
        current.isWord = true;
    }

    public boolean search(String word) {
        PrefixTrieNode current = root;
        for (Character ch: word.toCharArray()) {
            if (current.children.containsKey(ch)) {
                current = current.children.get(ch);
            } else
                return false;
        }
        //return true;
        return current.isWord;
    }

    public boolean delete(String word) {
        PrefixTrieNode current = root;
        PrefixTrieNode deleteBelow = null;
        Character deleteChar = null;
        for (Character ch: word.toCharArray()) {
            if (current.children.containsKey(ch)) {
                PrefixTrieNode child = current.children.get(ch);
                if (current.children.size() > 1 || current.isWord) {
                    deleteBelow = current;
                    deleteChar = ch;
                }
                current = child;
            } else
                return false;
        }

        if (!current.isWord) return false;

        if (current.children.isEmpty()) {
            if (deleteBelow != null) {
                deleteBelow.children.remove(deleteChar);
            }
        } else {
            current.isWord = false;
        }
        return true;
    }

    public static void main(String[] args) {
        PrefixTrie prefixTrie = new PrefixTrie();
        prefixTrie.insert("srushti");
        prefixTrie.insert("sru");
        prefixTrie.insert("sruti");
        System.out.println(prefixTrie.search("sru"));
        prefixTrie.delete("srushti");
        System.out.println(prefixTrie.search("sru"));
        System.out.println(prefixTrie.search("srushti"));
        System.out.println(prefixTrie.search("sruti"));
    }
}
