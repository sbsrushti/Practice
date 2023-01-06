package practice2021.youtube;

import java.util.HashMap;
import java.util.Map;
import org.junit.*;
import org.junit.runner.JUnitCore;

public class LRUCacheSolution {

    LRUCache<Integer, Integer> lruCache;

    public static void main(String[] args) {
        JUnitCore.main(args);
    }

    @Before
    public void setup() {
        lruCache = new LRUCacheImpl<>(1);
    }

    @Test
    public void testPositive() {
        Assert.assertNull(lruCache.get(1));
        lruCache.put(1,2);
        Assert.assertEquals(2, (int) lruCache.get(1));
        lruCache.put(3,4);
        Assert.assertNull(lruCache.get(1));
        Assert.assertEquals(4, (int) lruCache.get(3));
    }
}

interface LRUCache <K, V> {

    V get(K key);

    void put(K key, V value);
}

class LRUCacheImpl<K, V> implements LRUCache<K, V> {

    Node<K, V> first;
    Node<K, V> last;
    Map<K, Node<K, V>> cache;
    int capacity;

    LRUCacheImpl(int capacity) {
        this.capacity = capacity;
        this.first = null;
        this.last = null;
        this.cache = new HashMap<>();
    }

    @Override
    public V get(K key) {

        if (!this.cache.containsKey(key)) return null;

        Node<K, V> node = this.cache.get(key);

        if (node.next == null) return node.value;

        removeNode(node);
        addLast(node);

        return node.value;
    }

    @Override
    public void put(K key, V value) {

        if (this.cache.size() == this.capacity && !this.cache.containsKey(key)) {
            this.cache.remove(first.key);
            removeNode(first);
        }

        if (!this.cache.containsKey(key)) {
            Node<K, V> node = new Node<>(key, value);
            this.cache.put(key, node);
            addLast(node);
            return;
        }

        Node<K, V> node = this.cache.get(key);
        node.value = value;
        removeNode(node);
        addLast(node);
    }

    private void removeNode(Node<K, V> node) {

        Node<K, V> next = node.next;
        Node<K, V> prev = node.prev;

        if (first == last) {
            first = null;
            last = null;
        }

        else if (next == null) {
            last = prev;
            last.next = null;
        }

        else if (prev == null) {
            first = next;
            first.prev = null;
        }

        else {
            prev.next = next;
            next.prev = prev;
        }

        node.next = null;
        node.prev = null;
    }

    private void addLast(Node<K, V> node) {

        if (first == null) {
            first = node;
            last = node;

            return;
        }

        last.next = node;
        node.prev = last;
        last = node;
    }

    class Node<T, U> {
        T key;
        U value;
        Node<T, U> next;
        Node<T, U> prev;

        Node(T key, U value) {
            this.key = key;
            this.value = value;
            next = null;
            prev = null;
        }
    }
}