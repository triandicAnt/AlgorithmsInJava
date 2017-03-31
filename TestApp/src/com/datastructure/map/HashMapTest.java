import java.io.*;
import java.util.*;

/**
* K and V types 
**/
class MyHashtable<K, V> {

    /**
    * Node class store the type of Keys and Values
    **/
    class Node<K, V> {
    K key;
    V value;

    // Constructor
    public Node(K key, V value) {
      this.key = key;
      this.value = value;
    }
    
    // Setter and Getters    
     public K getKey() {
       return this.key;
    }
    
    public V getValue() {
       return this.value;
    }
    
    public void setValue(V value) {
       this.value = value;
    }
    // Checks whether the keys are same
    public boolean hasSameKey(K key) {
       return this.key == null ? this.key == key : this.key.equals(key);
    }
  }
  @SuppressWarnings("unchecked")
  /**
  * Member Variables
  **/
  // Default size is 32
  private final static int DEFAULT_SIZE = 32;
  // initial capacity 
  private int initialCapacity ; 
  // table to store the collison values
  private LinkedList<Node<K, V>> table[] = null;
                                  
  // Default Constructor
  public MyHashtable() {
    this(DEFAULT_SIZE);
  }

  // Parameterized Constructor
  public MyHashtable(int initialCapacity) {
    this.initialCapacity = initialCapacity;
    this.table = (LinkedList<Node<K, V>>[])new LinkedList[initialCapacity];
  }

  
   
  /**
  * Put method : expects two argument (Key and Value)
  **/
  public void put(K key, V value) {
    // Check for null key and values
    if (key == null || value == null) {
      if (key == null) {
        throw new IllegalArgumentException("NULL Key Exception!");
      } else {
        throw new IllegalArgumentException("NULL Value Exception!");
      }
    }
    // get the hascode of key
    int hashcode = simpleHash(key);
    // insert in the map
    insertKey(key, value, hashcode);

  }

  /**
  * insert key, value corresponding to a particular hascode in the map
  **/
  private void insertKey(K key, V value, int hashcode) {
    // get the index of table 
    int index = hashcode % initialCapacity;
    // if the index value is null, create a list 
      if ( table[index] == null ) {
         table[index] = new LinkedList<>();
      }
      // else find it and replace it
      for ( Node<K, V> i : table[index] ) {
         if ( i.hasSameKey(key) ) {
            table[index].remove(i);
            break;
         }
      }
      
      table[index].add( new Node<>(key, value) );
  }

  /**
  * Get method: expects a key
  **/
  public V get(K key) {
    if (key == null) {
      throw new IllegalArgumentException("Key parameter is NULL, it is not allowed");
    }
    // get the hascode
    int hashcode = simpleHash(key);
    // find the index
    int index = hashcode % initialCapacity;
    LinkedList<Node<K, V>> list = table[index];
    // if null then return null
    if (list == null) {
      return null;
    }
    // else look in the linked list
    for (Node<K, V> i : list) {
      if ( i.hasSameKey(key) ) {
            return i.getValue();
         }
    }
    return null;
  }
  // this method return the hash code for the key
   private int simpleHash(K key) {
    if ( key == null ) return 0;
    else {
       int hash = 7;
       String strKey = key.toString();
       for (int i=0; i < strKey.length(); i++) {
          hash = hash * 31 + strKey.charAt(i);
       }
       return hash;
    }
   }

   /**
   * ContainsKey checks whether a key is present in the map
   **/
   public boolean containsKey(K key) {
      int index = simpleHash(key) % initialCapacity;
      if ( table[index] == null ) {
         return false;
      }
      
      for ( Node<K, V> i : table[index] ) {
         if ( i.hasSameKey(key) ) {
            return true;
         }
      }
      return false;
   }
    
  /**
  * Override toString to preety print the map
  **/
  @Override
   public String toString() {
      StringBuilder sb = new StringBuilder();
      int index = 0;
      for ( int k = 0; k < initialCapacity; k++ ) {
         if ( table[k] != null ) {
            index = 0;
            sb.append("[").append(k).append("] -> {");
            for ( Node<K, V> i : table[k] ) {
               sb.append(i.getKey()).append(" = ").append(i.getValue());
               if ( index < table[k].size() -1 ) {
                  sb.append(", ");
               }
               index++;
            }
            sb.append("}\n");
         }
      }
      return sb.toString();
   }

  /**
   * A helper class that tests MyHashtable by feeding it puts and gets from STDIN.
   */
   static class TestHarness implements Runnable {

    final MyHashtable<String, String> hashtable;

    public TestHarness(MyHashtable<String, String> hashtable) {
      this.hashtable = hashtable;
    }

    public void run() {
      Scanner scanner = new Scanner(System.in);
      while (scanner.hasNext()) {
        String k = scanner.next();
        String v = null;
        if (k.contains("=")) {
          String[] split = k.split("\\=");
          k = split[0];
          if (split.length == 1) {
            v = null;
          } else {
            v = split[1];
          }
        }
        if (v == null) {
          System.out.println(hashtable.get(k));
        } else {
          hashtable.put(k, v);
        }
      }
    }
  }


    public static void main(String args[]) throws Exception {
    //new TestHarness(new MyHashtable<String, String>()).run();
      
      MyHashtable<Integer, Integer> map = new MyHashtable<>();
      map.put(1,2);
      map.put(2,2);
      map.put(3,3);
      System.out.println(map.get(1) + " " + map.get(2) + " " + map.get(3));
      
       MyHashtable<String, Integer> map1 = new MyHashtable<>();
      map1.put("1",2);
      map1.put("2",2);
      map1.put("3",3);
      System.out.println(map1.get("1") + " " + map1.get("2") + " " + map1.get("3"));
      
      MyHashtable<String, String> map2 = new MyHashtable<>();
      map2.put("hello","1");
      map2.put("how","2");
      map2.put("are","3");
      map2.put("you","4");
      map2.put("Hello","5");
      map2.put("Hello","8");
      System.out.println(map2.get("hello") + " " + map2.get("how") + " " + map2.get("are")+ " " + map2.get("you")+ " " + map2.get("Hello"));
      System.out.println(map2.containsKey("hello") + " " + map2.containsKey("how") + " " + map2.containsKey("aree")+ " " + map2.containsKey("yout")+ " " + map2.get("Hello"));
      System.out.println(map.toString());
      System.out.println(map1.toString());
      System.out.println(map2.toString());
  }
}



public class HashMapTest{
  

}
