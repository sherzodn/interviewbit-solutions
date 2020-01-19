package com.crossover.demo;

import java.util.HashMap;

public class LRUCache {
    class Node {
        public int key;
        public int val;
        public Node prev;
        public Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> map;
    Node start;
    Node end;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        start = new Node(0, 0);
        end = new Node(0, 0);
        start.next = end;
        end.prev = start;
    }

    public int get(int key) {
        if (map.containsKey(key)){
            Node node = map.get(key);
            removeNode(node);
            addNode(node);
            return node.val;
        }
        return -1;
    }

    public void set(int key, int value){
        Node node = new Node(key, value);
        if (map.containsKey(key)){
            Node temp = map.get(key);
            removeNode(temp);
            addNode(node);
        } else {
            if (capacity==map.size()) {
                Node temp = end.prev;
                removeNode(temp);
                map.remove(temp.key);
            }
            addNode(node);
        }
        map.put(key, node);
    }

    private void removeNode(Node node){
        Node temp = node.next;
        node.prev.next = temp;
        temp.prev = node.prev;
    }

    private void addNode(Node node){
        node.next = start.next;
        start.next = node;
        node.prev = start;
        node.next.prev = node;
    }
}
