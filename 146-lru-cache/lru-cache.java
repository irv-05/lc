class LRUCache {
    int capacity;
    HashMap<Integer, Integer> cache;
    HashMap<Integer, Node> priority;
    Node head;
    Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap();
        priority = new HashMap();

        this.head = new Node(null);
        this.tail = this.head;
    }

    private void print() {
        Node cur = head;
        System.out.print("Tail:" + tail.key + ",Head:" + head.key);
        while(cur != null) {
            System.out.print("Node:" + cur.key);
            cur = cur.right;
        }
        System.out.println();
    }
    
    public int get(int key) {
        if(!cache.containsKey(key)) {
            return -1;
        }

        updateUsage(key);
        //print();
        return cache.get(key);


    }
    
    public void put(int key, int value) {
        if(cache.containsKey(key)) {
            cache.put(key, value);
            updateUsage(key);
        } else {
            if(capacity == cache.size()) {
                evict();
            }
            add(key, value);
        }
                
       // print(); 
    }

    private void evict() {
        if(head.right != null) {
            Node evicted = head.right;
            if(tail.key == evicted.key) {
                tail = tail.left;
                tail.right = null;
            } else {
                head.right = evicted.right;
                evicted.right.left = head;
            }

            cache.remove(evicted.key);
            priority.remove(evicted.key);
        }
    }

    private void add(int key, int value) {
        Node cur = new Node(key);
        priority.put(key, cur);
        cache.put(key, value);
        appendToTail(cur);
    }

    private void updateUsage(int key) {
        Node cur = priority.get(key);
        if(cur.right != null) {
            cur.left.right = cur.right;
            cur.right.left = cur.left;
            cur.right = null;
            appendToTail(cur);
        }
    }

    private void appendToTail(Node cur) {
            tail.right = cur;
            cur.left = tail;
            tail = cur;    
    }

    class Node {
        public Node left = null;
        public Node right = null;
        public Integer key;

        public Node(Integer key) {
            this.key = key;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */