import java.util.Scanner;

public class iWordDictionaryWildcard {

    static class WordDictionary {

        // Trie node
        static class Node {

            Node[] children = new Node[26];

            boolean isEnd;
        }

        private final Node root = new Node();

        // Add a word to the dictionary
        public void addWord(String word) {

            Node current = root;

            for (char ch : word.toCharArray()) {

                int index = ch - 'a';

                if (current.children[index] == null) {

                    current.children[index] = new Node();
                }

                current = current.children[index];
            }

            current.isEnd = true;
        }

        // Search a word, allowing '.' as wildcard
        public boolean search(String word) {

            return searchHelper(root, word, 0);
        }

        private boolean searchHelper(
                Node current,
                String word,
                int index) {

            // Entire pattern has been processed
            if (index == word.length()) {

                return current.isEnd;
            }

            char ch = word.charAt(index);

            // Case 1: Wildcard character
            if (ch == '.') {

                // Try every possible child
                for (Node child : current.children) {

                    if (child != null &&
                        searchHelper(child, word, index + 1)) {

                        return true;
                    }
                }

                return false;
            }

            // Case 2: Normal character
            int position = ch - 'a';

            if (current.children[position] == null) {

                return false;
            }

            return searchHelper(
                current.children[position],
                word,
                index + 1
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        WordDictionary dictionary = new WordDictionary();

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {

            String command = sc.next();

            String word = sc.next();

            switch (command.toUpperCase()) {

                case "ADDWORD":

                    dictionary.addWord(word);
                    break;

                case "SEARCH":

                    System.out.println(dictionary.search(word));
                    break;

                default:

                    System.out.println("Invalid operation");
            }
        }

        sc.close();
    }
}