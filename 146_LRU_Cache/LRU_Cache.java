// https://leetcode.com/problems/lru-cache/

public class LRUCache {
    
    private class Node {
        int key;
        int value;
        Node pre;
        Node next;
        
        public Node(int key, int value){
            this.key = key;
            this.value = value;
            this.pre = null;
            this.next = null;
        }
    }
    
    private HashMap<Integer, Node> map = new HashMap<Integer, Node>();
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = new Node(-1, -1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head.next = tail;
        tail.pre = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        
        Node current = map.get(key);
        // first remove the called node from the current position
        current.pre.next = current.next;
        current.next.pre = current.pre;
        // next move the called node to the end of the list
        moveToTail(current);
        
        return current.value;
    }
    
    public void set(int key, int value) {
        if(get(key) != -1){
            map.get(key).value = value;
            return;
        }
        
        if(map.size() == capacity){
            //remove the node next to head
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.pre = head;
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
    }
    
    private void moveToTail(Node current){
        current.pre = tail.pre;
        tail.pre = current;
        current.pre.next = current;
        current.next = tail;
    }
}