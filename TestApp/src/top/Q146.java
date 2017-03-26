puvlic class Q146{
}
class LRUCache {
    Node head;
    Node tail;
    Map<Integer, Node> cache;
    int capacity;
    int c ;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new Node(0,0);
        tail = new Node(0,0);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node temp = cache.get(key);
        if(temp!=null){
            moveToHead(temp);
            return temp.v;
        }
        return -1; 
    }
    
    public void put(int key, int value) {
        Node temp = cache.get(key);
        if(temp == null){
            temp = new Node(key,value);
            c++;
           // System.out.println(c + " "+ capacity);
            if(c>capacity){
                int x = popTail();
               // System.out.println(x + "removed");
                cache.remove(x);
                c--;
            }
            cache.put(key,temp);
            addToHead(temp);
           // capacity++;

        }else{
            temp.v = value;
            moveToHead(temp);
        }
       // System.out.println(cache);

    }
    public void moveToHead(Node temp){
        remove(temp);
        addToHead(temp);
    }
    public void remove(Node temp){
        Node p = temp.prev;
        Node n = temp.next;
        if(p!=null){
            p.next = n;
            temp.prev = null;
        }
        if(n!=null){
            n.prev = p;
            temp.next = null;
        }
    }
    public void addToHead(Node temp){
        Node n = head.next;
        temp.next = n;
        temp.prev = head;
        head.next = temp;
        n.prev = temp;
    }
    public int popTail(){
        Node p = tail.prev;
        p.prev.next = p.next;
        p.next.prev = p.prev;
        return p.k;
    }
}
class Node{
    int k;
    int v;
    Node prev;
    Node next;
    Node(int k,int v){
        this.k = k;
        this.v = v;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
