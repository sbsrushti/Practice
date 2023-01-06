package practice2021.ctci.treesandgraphs.refreshertwo;

// { Driver Code Starts
//Initial Template for Java

import java.util.*;

class GFG
{
    public static void main(String args[])
    {
        char[][] board = {{'d', 'd'}, {'b', 'f'}, {'e', 'c'}, {'b', 'c'}, {'d', 'c'}};
        String[] dictionary = {"bcd", "db"};

        Solution solution = new Solution();
        String[] result = solution.wordBoggle(board, dictionary);

        for (String str: result) {
            System.out.println(str);
        }
    }
}
// } Driver Code Ends


//User function Template for Java
class TrieNode {
    Character ch;
    Map<Character, TrieNode> children;
    boolean end;

    TrieNode(Character ch) {
        this.ch = ch;
        this.children = new HashMap<>();
        this.end = false;
    }
}

class Solution
{
    int[][] children = {{1,0}, {0,1}, {0,-1}, {-1,0}, {-1,-1}, {1,1}, {1,-1}, {-1,1}};

    public String[] wordBoggle(char board[][], String[] dictionary)
    {
        TrieNode head = new TrieNode('\0');
        for (int i = 0; i < dictionary.length; i++) {
            addWord(head, dictionary[i], 0);
        }
        //printTrieNode(head);

        Set<String> result = new HashSet<>();
        boolean[][] recStack = new boolean[board.length][board[0].length];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                recStack[i][j] = true;
                dfs(board, result, recStack, head, i, j, "");
                recStack[i][j] = false;
            }
        }

        String[] resArr = new String[result.size()];

        return result.toArray(resArr);
    }

    private void printTrieNode(TrieNode node) {
        for (Map.Entry<Character, TrieNode> entry: node.children.entrySet()) {
            System.out.println(entry.getKey() + ", " + entry.getValue().end);
            printTrieNode(entry.getValue());
        }
        System.out.println();
    }

    private void dfs(char board[][], Set<String> result,
                     boolean[][] recStack, TrieNode node, int i, int j, String temp) {
        //System.out.println(temp);
        if (node.children.containsKey(board[i][j])) {
            temp = temp + board[i][j];

            if (node.children.get(board[i][j]).end) {
                result.add(new String(temp));
            }

            for (int x = 0; x < children.length; x++) {
                int new_i = i + children[x][0];
                int new_j = j + children[x][1];
                if (new_i >= 0 && new_i < board.length &&
                        new_j >= 0 && new_j < board[0].length &&
                        !recStack[new_i][new_j]) {
                    //System.out.println("new i: " + new_i + "new j: " + new_j);

                    recStack[new_i][new_i] = true;
                    dfs(board, result, recStack, node.children.get(board[i][j]),
                            new_i, new_j, temp);
                    recStack[new_i][new_i] = false;
                }
            }

            if (temp.length() > 0)
                temp = temp.substring(0, temp.length()-1);
        }
    }

    // addWord(node, "CAT", 0)
    // "\0" -> C" -> "A" -> "T*"
    private void addWord(TrieNode node, String word, int pos) {
        if (pos < word.length()) {
            if (node.children.containsKey(word.charAt(pos))) {
                node = node.children.get(word.charAt(pos));
            } else {
                TrieNode newNode = new TrieNode(word.charAt(pos));
                if (pos == word.length()-1) {
                    newNode.end = true;
                }
                node.children.put(word.charAt(pos), newNode);
                node = newNode;
            }

            addWord(node, word, pos+1);
        }
    }
}
