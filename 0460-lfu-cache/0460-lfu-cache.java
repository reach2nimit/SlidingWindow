class LFUCache {

    private final int capacity;
    private int size;
    private int minFreq;
    private final Map<Integer, Node> nodeMap;
    private final Map<Integer, DList> freqMap;

    public LFUCache(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.minFreq = 0;
        this.nodeMap = new HashMap();
        this.freqMap = new HashMap();
    }

    public int get(int key){
        Node node = nodeMap.get(key);
        if(node == null)
            return -1;
        
        touch(node);
        return node.value;
    }

    public void put(int key, int value){
        if(capacity==0)
            return;

        if(nodeMap.containsKey(key)){
            Node node = nodeMap.get(key);
            node.value = value;
            touch(node);
            return;
        } 

        if(size==capacity){
            DList evictList = freqMap.get(minFreq);
            Node toRemove = evictList.removeLast();
            nodeMap.remove(toRemove.key);
            size--;
        }

        Node node = new Node(key, value);
        nodeMap.put(key, node);
        freqMap.computeIfAbsent(1, f -> new DList()).addFirst(node);
        minFreq = 1;
        size++;
    }

    public void touch(Node node){
        int oldFreq = node.freq;
        DList oldList = freqMap.get(oldFreq);
        oldList.remove(node);

        if(oldFreq == minFreq && oldList.isEmpty())
            minFreq++;
        
        node.freq = oldFreq + 1;
        freqMap.computeIfAbsent(node.freq,f -> new DList()).addFirst(node);
    }

    class Node{
        int key;
        int value;
        int freq;
        Node prev, next;
        Node(int key, int value){
            this.key=key;
            this.value=value;
            this.freq=1;
        }
    }

    class DList{
        Node tail, head;
        int size;

        DList(){
            tail = new Node(0,0);
            head = new Node(0,0);
            head.next = tail;
            tail.prev = head;
            size = 0;
        }

        public void remove(Node node){
            node.next.prev = node.prev;
            node.prev.next = node.next;
            node.prev = node.next = null;
            size--;
        }

        public void addFirst(Node node){
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
            size++;
        }

        public Node removeLast(){
            if(size==0)
                return null;
            
            Node node = tail.prev;
            remove(node);
            return node;
        }

        public boolean isEmpty(){
            return size==0;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */