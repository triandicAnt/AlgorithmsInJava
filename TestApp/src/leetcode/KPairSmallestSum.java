package leetcode;

import java.util.List;
import java.util.PriorityQueue;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class KPairSmallestSum {
	 public List<int[]> kSmallestPairs(int[] Numbs1, int[] Numbs2, int k) {
	       /* int m = Numbs1.length;
	        int n = Numbs2.length;
	        List<int[]> list = new ArrayList<>();
	        if(m==0||n==0){
	            return list;
	        }
	        if(m*n<k){
	            //return all pair
	            for(int a:Numbs1){
	                for(int b:Numbs2){
	                    int []arr = new int [2];
	                    arr[0] = a;
	                    arr[1] = b;
	                   // Arrays.sort(arr);
	                    list.add(arr);
	                }
	            }
	            return list;
	        }
	        PriorityQueue<Numb> pq = new PriorityQueue<Numb>(new Comparator<Numb>(){
	            @Override
	            public int compare(Numb x, Numb y){
	                if(x.sum>y.sum)
	                    return 1;
	                else if(x.sum<y.sum)
	                    return -1;
	                else
	                    return 0;
	            }
	        });
	        
	        int i=0;
	        int j=0;
	        if(Numbs1[i]>Numbs2[j]){
	            for(int a:Numbs1)
	                pq.offer(new Numb(Numbs2[j], a));
	            j++;
	        }else if(Numbs1[i]<=Numbs2[j]){
	            for(int a:Numbs2)
	                pq.offer(new Numb(Numbs1[i], a));
	            i++;
	        }
	        
	        while(k>0 && pq.size()>0){
	            int[] p = pq.poll().pair;
	            //Arrays.sort(p);
	            list.add(p);
	            k--;
	            if(i>0 && i<m){
	                for(int a:Numbs2)
	                    pq.offer(new Numb(Numbs1[i], a));
	                i++;
	            }else if(j>0 && j<n){
	                for(int a:Numbs1)
	                    pq.offer(new Numb(Numbs2[j], a));
	                j++;
	            }
	        }
	        return list; */
	        
//	        PriorityQueue<int[]> que = new PriorityQueue<>((a,b)->a[0]+a[1]-b[0]-b[1]);
//	        List<int[]> res = new ArrayList<>();
//	        if(Numbs1.length==0 || Numbs2.length==0 || k==0) return res;
//	        for(int i=0; i<Numbs1.length && i<k; i++) que.offer(new int[]{Numbs1[i], Numbs2[0], 0});
//	        while(k-- > 0 && !que.isEmpty()){
//	            int[] cur = que.poll();
//	            res.add(new int[]{cur[0], cur[1]});
//	            if(cur[2] == Numbs2.length-1) continue;
//	            que.offer(new int[]{cur[0],Numbs2[cur[2]+1], cur[2]+1});
//	        }
//	        return res;
	    return null;
	        
	    }
	}
	class Numb{
	    int sum;
	    int []pair;
	    Numb(int x, int y){
	        this.sum = x+y;
	        pair = new int [2];
	        pair[0] = x;
	        pair[1] = y;
	    }
	}
