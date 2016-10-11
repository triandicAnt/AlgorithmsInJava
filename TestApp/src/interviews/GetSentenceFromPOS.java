package interviews;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GetSentenceFromPOS {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(testNLP("(NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages))))"));
//		System.out.println(extractSentence("(NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages))))"));
//		System.out.println(testNLP("(S (NP (NNP James)) (VP (VBZ is) (NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages))))))"));
//		System.out.println(extractSentence("(S (NP (NNP James)) (VP (VBZ is) (NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages))))))"));
		System.out.println(extractSentence("(NNS sausages)"));

	}
	public static String testNLP(String str){
		/*
		 * 
			(NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages))))
			(S (NP (NNP James)) (VP (VBZ is) (NP (NP (DT a) (NN boy)) (VP (VBG eating) (NP (NNS sausages))))))

		 */
		
		String [] strArray = {"S","NNP","NNS","NP","NP", "DT","VP","VBG", "VBZ", "NN"};
		String temp = str;
		for(String a: strArray){
			if(temp.contains(a))
				temp = temp.replaceAll(a, " ");
		}
//		System.out.println(temp + "------");
		temp = temp.replaceAll("\\(", " ");
		temp = temp.replaceAll("\\)", " ");

		return temp.trim().replaceAll(" +", " ");
	}
	
	public static String extractSentence(String str){
		Pattern regexpPattern = Pattern.compile("([A-Z]?[a-z]+)\\)");
		Matcher m = regexpPattern.matcher(str);
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
		    sb.append(m.group(1));
		    sb.append(" ");
		}
		return sb.toString();
	}
}
