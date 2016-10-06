package string;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class FindSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Computer Science".toLowerCase());
		String str = "Computer Science Engineering|Computer Science | Computer-Science-Engineering";
		
		PriorityQueue<Sentence> pq =  new PriorityQueue<Sentence>(new Comparator<Sentence>(){
			  @Override
				// Min Heap
				  public int compare(Sentence i, Sentence j){
					  if(i.wordCount>j.wordCount)
						  return 1;
					  if(i.wordCount<j.wordCount)
						  return -1;
					  else 
						  return 0;
				  }
			  });
		
//		System.out.println(Arrays.toString("computer-science-engineering".split("-|\\s")));
		String [] stringArray = str.split("\\|");
		System.out.println(Arrays.toString(stringArray));
		for(String a: stringArray){
			pq.offer(new Sentence(a));			
		}
		
		System.out.println(pq);
		
		// Merge the sentences in the priority queue
		while(pq.size() >=1){
			Sentence s1 = pq.poll();
			Sentence s2 = pq.poll();
			if(containsString(s1.sentence, s2.sentence)){
				pq.offer(s2);
			}else{
				pq.offer(s2);
				break;
			}
		}
		
		System.out.println(containsString("computer science engineering", "computer-science-engineering"));
		System.out.println(pq);

	}
	
//	"Computer Science Engineering|Computer Science | Computer-Science-Engineering"
	
	static boolean containsString(String s1, String s2){
		return Pattern.compile(Pattern.quote(s1), Pattern.CASE_INSENSITIVE).matcher(s2).find();
	}
	
}

class Sentence{
	String sentence;
	int wordCount;
	String old;
	public Sentence(String sentence){
		this.old = sentence;
		this.sentence = sentence.toLowerCase().trim();
		String [] strArr = this.sentence.split("[\\s-]+");
//		System.out.println(Arrays.toString(strArr));
		this.wordCount = strArr.length;
	}
	
	public String toString(){
		return this.sentence + "=" + this.wordCount + "=" + this.old;
	}
}
