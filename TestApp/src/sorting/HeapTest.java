import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author Sudhansu
 *
 */

public class HeapTest
{
  public static void main(String[] args)
  {
  // List<String> places = Arrays.asList("Buenos Aires", "Córdoba", "La Plata");
	List<Integer> a = new ArrayList<>(Arrays.asList(4,3,6,7,1,0,9,2,8));
    Heap<Integer> hp = new Heap<>();
    System.out.println(a);
    hp.heapSort(a, a.size());
    hp.printHeap();
    hp.insert(5);
    hp.printHeap();
    System.out.println(hp.extract());
    hp.printHeap();
    System.out.println(hp.extract());
    System.out.println(hp.extract());
    System.out.println(hp.extract());
    hp.printHeap();
    hp.insert(2);
    hp.insert(3);
    hp.insert(1);
    hp.printHeap();
    System.out.println(a);
    /*
    Heap<String> hp1 = new Heap<>();
    List<String> b = new ArrayList<>(Arrays.asList("B","S","A","D","E","C"));
    hp1.printArray(b);
    hp1.heapSort(b, b.size());
    hp1.printArray(b);
    */
  }
}

class Heap<T extends Comparable<T>>{
	MaxHeap mH;
	class MaxHeap{
	    int len;
	    List<T> array;
	    public MaxHeap(int size, List<T> array){
	      this.len = size;
	      this.array = array;
	    }
	  }
  public MaxHeap createAndBuildHeap(List<T>array, int size){
   		 mH = new MaxHeap(size,array);
    	for(int i = (size-2)/2; i>=0;i--){ //
      		heapify(mH,i);
    	}
    return mH;
  }
  public void heapify(MaxHeap mH, int index){
   	int l = index;
    int left = 2*index+1;
    int right = 2*index+2;
    
    if(left<mH.len && mH.array.get(left).compareTo(mH.array.get(l))>0)
      	l = left;
    if(right<mH.len && mH.array.get(right).compareTo(mH.array.get(l))>0)
      	l = right;
    if(l!=index){
     	swap(mH.array,l, index);
      	heapify(mH,l);
    }
  }
  public void swap(List<T> array, int i, int j){
   	T temp = array.get(i);
    array.set(i,array.get(j));
    array.set(j,temp);
  }
  
  public void heapSort(List<T> array, int size){
   	MaxHeap mH = createAndBuildHeap(array,size);
    while(mH.len>1){
     	swap(mH.array, 0, mH.len-1);
      	--mH.len;
      	heapify(mH,0);
    }
    mH.len = size;
  }
  void printHeap(){
		for (int i = 0; i < this.mH.array.size(); i++) {
			System.out.print(this.mH.array.get(i) + " ");
		}
		System.out.println();
	}
  public void insert(T value){
	  this.mH.len++;
	  this.mH.array.add(value);
	  heapSort(this.mH.array,this.mH.len);
  }
   public T extract(){
	   T val = this.mH.array.get(0);
	   swap(mH.array, 0,this.mH.array.size()-1);
	   this.mH.array.remove(this.mH.array.size()-1);
	   this.mH.len--;
	   heapSort(this.mH.array,this.mH.len);
	   return val;
  }
}
