public class LFUCache {
    Node head;
    HashMap<Integer, Integer> valueMap;
    HashMap<Integer, Node> nodeMap;
    int capacity;
    
    public LFUCache(int capacity) {
        head=null;
        this.capacity = capacity;
        valueMap = new HashMap<>();
        nodeMap = new HashMap<>();
    }
    
    public int get(int key) {
        if(valueMap.containsKey(key)){
            incrementCount(key);
            return valueMap.get(key);
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(this.capacity==0)
            return;
        if(valueMap.containsKey(key)){
            valueMap.put(key, value);
        }else{
            if(valueMap.size()>=capacity){
                removeOld();
            }
            valueMap.put(key,value);
            addToHead(key);
        }
        incrementCount(key);
    }
    public void removeOld(){
        if(head == null)
            return;
        int old = 0;
        for(int i : head.keys){
            old = i;
            break;
        }
        head.keys.remove(old);
        if(head.keys.size()==0)
            remove(head);
        valueMap.remove(old);
        nodeMap.remove(old);
    }
    public void remove(Node node){
        if(node.prev==null){
            head = node.next;
        }else{
            node.prev.next = node.next;
        }
        if(node.next!=null){
            node.next.prev = node.prev;
        }
    }
    public void addToHead(int k){
        if(head==null){
            head = new Node(0);
            head.keys.add(k);
        }else if(head.count >0){
            Node temp = new Node(0);
            temp.keys.add(k);
            temp.next = head;
            head.prev = temp;
            head = temp;
        }else{
            head.keys.add(k);
        }
        nodeMap.put(k,head);
    }
    public void incrementCount(int k){
        Node n = nodeMap.get(k);
        if(n==null)
            return;
        n.keys.remove(k);
        if(n.next==null){
            n.next = new Node(n.count+1);
            n.next.keys.add(k);
            n.next.prev = n;
        }else if(n.count == n.next.count-1){
            n.next.keys.add(k);
        }else{
            Node temp = new Node(n.count+1);
            temp.keys.add(k);
            temp.prev = n;
            temp.next = n.next;
            n.next.prev = temp;
            n.next = temp;
        }
        nodeMap.put(k, n.next);
        if(n.keys.size()==0)
            remove(n);
    }
    
}

class Node{
    int count;
    LinkedHashSet<Integer> keys;
    Node prev;
    Node next;
    public Node(int count){
        this.count = count;
        keys = new LinkedHashSet<>();
        prev = null;
        next = null;
    }
}


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
