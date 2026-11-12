import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class iLRUCache {

    static class Node {

        int key;
        int value;

        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    static class LRUCache {

        private final int capacity;

        private final Map<Integer, Node> map;

        // Dummy head and tail nodes
        private final Node head;
        private final Node tail;

        LRUCache(int capacity) {

            this.capacity = capacity;

            map = new HashMap<>();

            head = new Node(0, 0);
            tail = new Node(0, 0);

            head.next = tail;
            tail.prev = head;
        }

        // Remove a node from its current position
        private void removeNode(Node node) {

            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        // Insert a node immediately after head
        private void addToFront(Node node) {

            node.next = head.next;
            node.prev = head;

            head.next.prev = node;
            head.next = node;
        }

        // Mark a node as recently used
        private void moveToFront(Node node) {

            removeNode(node);

            addToFront(node);
        }

        // Get value associated with key
        public int get(int key) {

            Node node = map.get(key);

            if (node == null) {
                return -1;
            }

            // Mark as recently used
            moveToFront(node);

            return node.value;
        }

        // Insert or update a key-value pair
        public void put(int key, int value) {

            // Check whether key already exists
            Node node = map.get(key);

            if (node != null) {

                node.value = value;

                moveToFront(node);

                return;
            }

            // Create a new node
            Node newNode = new Node(key, value);

            map.put(key, newNode);

            addToFront(newNode);

            // Remove least recently used node if full
            if (map.size() > capacity) {

                Node lru = tail.prev;

                removeNode(lru);

                map.remove(lru.key);
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int capacity = sc.nextInt();

        int operations = sc.nextInt();

        LRUCache cache = new LRUCache(capacity);

        for (int i = 0; i < operations; i++) {

            String command = sc.next().toUpperCase();

            switch (command) {

                case "PUT":

                    int key = sc.nextInt();

                    int value = sc.nextInt();

                    cache.put(key, value);

                    break;

                case "GET":

                    int searchKey = sc.nextInt();

                    System.out.println(cache.get(searchKey));

                    break;
            }
        }

        sc.close();
    }
}