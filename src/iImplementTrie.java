import java.util.Scanner;

public class iImplementTrie {

    static class Trie {

        // Each node represents one character
        static class Node {

            Node[] children = new Node[26];

            // Indicates whether a complete word ends here
            boolean isEnd;
        }

        private final Node root = new Node();

        // Insert a word into Trie
        public void insert(String word) {

            Node current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                // Create node if it doesn't exist
                if (current.children[index] == null) {

                    current.children[index] = new Node();
                }

                current = current.children[index];
            }

            // Mark the end of the complete word
            current.isEnd = true;
        }

        // Search for a complete word
        public boolean search(String word) {

            Node current = findNode(word);

            return current != null && current.isEnd;
        }

        // Check whether a prefix exists
        public boolean startsWith(String prefix) {

            return findNode(prefix) != null;
        }

        // Find the node corresponding to a string
        private Node findNode(String str) {

            Node current = root;

            for (char ch : str.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {

                    return null;
                }

                current = current.children[index];
            }

            return current;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Trie trie = new Trie();

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {

            String command = sc.next();

            String word = sc.next();

            switch (command.toUpperCase()) {

                case "INSERT":

                    trie.insert(word);
                    break;

                case "SEARCH":

                    System.out.println(trie.search(word));
                    break;

                case "STARTSWITH":

                    System.out.println(trie.startsWith(word));
                    break;

                default:

                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}