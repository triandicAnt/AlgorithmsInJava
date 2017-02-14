import java.util.Hashtable;
public class LRUCache {
    // a cache Hashtable;
    Hashtable<Integer, DLinkedList> cache;
    int count;
    int capacity;
    DLinkedList head;
    DLinkedList tail;


    public LRUCache(int capacity) {
        this.cache = new Hashtable<>();
        this.count = 0;
        this.capacity = capacity;
        this.head = new DLinkedList();
        this.tail = new DLinkedList();
        head.pre = null;
        head.post = tail;
        tail.pre = head;
        tail.post = null;
    }
    
    public int get(int key) {
        DLinkedList temp = this.cache.get(key);
        if(temp == null)
            return -1;
        this.moveToHead(temp);
        return temp.value;
    }
    
    public void put(int key, int value) {
        DLinkedList temp = this.cache.get(key);
        if(temp == null){
            DLinkedList newNode = new DLinkedList(key, value);
            this.cache.put(key, newNode);
            this.add(newNode);
            this.count++;
            // check for overflow
            if(this.count>this.capacity){
                DLinkedList pop = popTail();
                this.cache.remove(pop.key);
                this.count-- ;
            }
        }else{
            temp.value = value;
            this.moveToHead(temp);
        }
    }
    
    // add : add always after head
    private void add(DLinkedList node){
        node.pre = head;
	    node.post = head.post;
	
	    head.post.pre = node;
    	head.post = node;
    }
    
    // remove 
    private void remove(DLinkedList node){
        node.pre.post = node.post;
        node.post.pre = node.pre;
    }
    
    // move to head
    private void moveToHead(DLinkedList node){
        remove(node);
        add(node);
    }
    // popTail
    private DLinkedList popTail(){
        DLinkedList res = this.tail.pre;
        remove(res);
        return res;
    }
}
//create a DLinkedList class
// define add
// define remove
// define moveToHead
// define popTail

class DLinkedList{
    int key;
    int value;
    DLinkedList pre;
    DLinkedList post;
    public DLinkedList(){
        
    }
    public DLinkedList(int key, int value){
        this.key = key;
        this.value = value;
    }
}
/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
