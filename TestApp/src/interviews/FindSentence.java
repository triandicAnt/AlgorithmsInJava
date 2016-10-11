package interviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.regex.Pattern;

public class FindSentence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "Computer Science Engineering|Computer Science | Computer-Science-Engineering";
		String str = "IBM cognitive computing|IBM \"cognitive\" computing is a revolution| ibm cognitive  computing|'IBM Cognitive Computing' is a revolution?";
		//String str = "\"Computer Science Department\"|Computer-Science-Department|the \"computer science department\"";
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
		for(String a: stringArray){
			pq.offer(new Sentence(a));			
		}
		
		System.out.println(pq);
		// Merge the sentences in the priority queue
		while(pq.size() >=1){
			Sentence s1 = pq.poll();
			Sentence s2 = pq.poll();
//			System.out.println(s1);
//			System.out.println(s2);
			if(s1!=null && s2!=null){
				if(containsString(s1.sentence, s2.sentence)){
					pq.offer(s2);
				}else{
					pq.offer(s2);
					break;
				}
			}
		}
		System.out.println(pq);
		List<Sentence> list = new ArrayList<>();
		for(Sentence s: pq){
//			System.out.println(s.sentence);
			list.add(s);
		}
		boolean flag = true;
		for(int i=1;i<list.size();i++){
			if(list.get(i-1).sentence.equals(list.get(i).sentence)){
				flag = false;
				break;
			}
		}
		if(flag == false){
			System.out.println(list.get(0).old);
		}else{
			System.out.println(pq);
		}
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
		//this.sentence = sentence.toLowerCase().trim();
		String str = sentence.toLowerCase().replaceAll("[^A-Za-z0-9 ]", " ").replaceAll("\\s{2,}", " ").trim();
//		System.out.println(str);
		this.sentence = str;

		String [] strArr = this.sentence.split("[\\s-]+");
//		System.out.println(Arrays.toString(strArr));
		this.wordCount = strArr.length;
	}
	
	public String toString(){
		return this.sentence + "=" + this.wordCount + "=" + this.old;
	}
}
