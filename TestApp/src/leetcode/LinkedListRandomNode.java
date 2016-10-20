/**
 * 
 */
package leetcode;

import java.util.Random;

/**
 * @author Sudhansu
 *https://leetcode.com/problems/linked-list-random-node/
 */

public class LinkedListRandomNode {

    /** @param head The linked list's head.
        Note that the head is guaranteed to be not null, so it contains at least one node. */
        ListNode head;
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
    }
    
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode cur = head;
        int l =0;
        while(cur!=null){
            l++;
            cur = cur.next;
        }
        int r = randInt(0,l-1);
        int i=0;
        cur = head;
        
        while(i!=r){
            cur = cur.next;
            i++;
        }
        return cur.val;
    }
    public int randInt(int min, int max) {
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
}
}
