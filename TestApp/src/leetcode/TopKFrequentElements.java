/**
 * 
 */
package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * @author Sudhansu
 * https://leetcode.com/problems/top-k-frequent-elements/
 */

public class TopKFrequentElements {
    public List<Integer> topKFrequent(int[] nums, int k) {
        if(nums.length<1 || k == 0)
            return null;
        List<Integer> list = new ArrayList<Integer>();
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int a : nums){
            if(map.containsKey(a)){
                map.put(a, map.get(a)+1);
            }else{
                map.put(a, 1);
            }
        }
        PriorityQueue<MyNumber> pq = new PriorityQueue<>(new Comparator<MyNumber>(){
                public int compare(MyNumber i, MyNumber j){
                    if(i.count>j.count){
                        return -1;
                    }else if(i.count<j.count){
                        return 1;
                    }else{
                        return 0;
                    }
                }
            });
         for(Entry<Integer, Integer> e: map.entrySet()){
             pq.offer(new MyNumber((int)e.getKey(), (int)e.getValue()));
         }
         while(k>0){
             list.add(pq.poll().num);
             k--;
         }
         return list;
        }
        
    }

class MyNumber{
    int num;
    int count;
    MyNumber(int num, int count){
        this.num = num;
        this.count = count;
    }
    public boolean equals(Object obj){
        MyNumber newNum = (MyNumber)obj;
        return(this.num == newNum.num);
    }
}