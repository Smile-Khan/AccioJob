// QUESTION :- LRU Cache

// Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

// Implement the LRUCache class:

// LRUCache(int capacity) Initialize the LRU cache with positive size capacity.

// int get(int key) Return the value of the key if the key exists, otherwise return -1.

// void set(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.

// The functions get and set must each run in O(1) average time complexity.

// Input Format:
// First line of input contains the cap size of LRU.

// Second line of input contains the number of queries Q.

// Third line of input contains the queries containing GET followed by single integer and SET followed by 2 integers.

// Output Format
// Print the output of the GET queries.

// Example 1
// Input:

// cap = 2
// Q = 2
// Queries = SET 1 2 GET 1
// Output::

// 2
// Explanation

// Cache Size = 2

// SET 1 2 GET 1

// SET 1 2 : 1 -> 2

// GET 1 : Print the value corresponding

// to Key 1, ie 2.

// Example 2
// Input:

// cap = 2
// Q = 8
// Queries =SET 1 2 SET 2 3 SET 1 5
// SET 4 5 SET 6 7 GET 4 SET 1 2 GET 3
// Output::

// 5 -1
// Explanation

// Cache Size = 2

// SET 1 2 : 1 -> 2

// SET 2 3 : 1 -> 2, 2 -> 3 (the most recently

// used one is kept at the rightmost position)

// SET 1 5 : 2 -> 3, 1 -> 5

// SET 4 5 : 1 -> 5, 4 -> 5 (Cache size is 2, hence

// we delete the least recently used key-value pair)

// SET 6 7 : 4 -> 5, 6 -> 7

// GET 4 : Prints 5 (The cache now looks like 6 -> 7, 4->5)

// SET 1 2 : 4 -> 5, 1 -> 2 (Cache size is 2, hence we delete the least recently used key-value pair)

// GET 3 : No key value pair having key = 3. Hence, -1 is printed.

// Constraints
// 1 <= cap <= 1000

// 1 <= Q <= 10000

// 1 <= x, y <= 1000


 SOLUTION :- 


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private final Node head;
    private final Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(-1, -1); // Dummy head node
        this.tail = new Node(-1, -1); // Dummy tail node
        this.head.next = tail;
        this.tail.prev = head;
    }

    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1; // Key not found
        }

        Node node = cache.get(key);
        moveToHead(node); // Move accessed node to the front (most recently used)
        return node.value;
    }

    public void set(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node); // Move updated node to the front (most recently used)
        } else {
            if (cache.size() >= capacity) {
                Node toRemove = tail.prev;
                removeNode(toRemove);
                cache.remove(toRemove.key);
            }

            Node newNode = new Node(key, value);
            addToFront(newNode);
            cache.put(key, newNode);
        }
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToFront(node);
    }

    private void addToFront(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cap = sc.nextInt();
        int q = sc.nextInt();
        LRUCache lruCache = new LRUCache(cap);

        for (int i = 0; i < q; i++) {
            String s = sc.next();
            if (s.equals("GET"))
                System.out.println(lruCache.get(sc.nextInt()));
            else
                lruCache.set(sc.nextInt(), sc.nextInt());
        }
        sc.close();
    }
}
