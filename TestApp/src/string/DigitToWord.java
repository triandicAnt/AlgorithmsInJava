/**
 * 
 */
package string;

/**
 * @author Sudhansu
 *
 */
public class DigitToWord {

	/**
	 * @param args
	 */
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DigitToWord d = new DigitToWord();
		System.out.println(d.getNumberOfDigitsRepresent(5019));
		System.out.println(d.numberComplement(7));
		System.out.println(d.intToWord(3268174));
	}
	int getNumberOfDigitsRepresent(int n){
		return (int)Math.floor(Math.log(n)/Math.log(2)) + 1;
	}
	int numberComplement(int n){
		int x = getNumberOfDigitsRepresent(n);
		int y = (int)Math.pow(2, x)-1;
		return n^y;
	}
	String intToWord(int num){
		String []base = new String []{""," Thousand ", " Million ", " Billion "};
		String []teen = new String []{" Ten ", " Eleven ", " Twelve ", " Thirteen "
				," Fourteen ", " Fifteen ", " Sixteen ", " Seventeen ", " Eighteen ",
				" Nineteen "};
		String []ty = new String []{ "", "", " Twenty ", " Thirty ", " Forty ", " Fifty ", " Sixty ",
				" Seventy ", " Eighty ", " Ninety " };
		String digit[] = { "Zero", "One", "Two", "Three", "Four", "Five",
				"Six", "Seven", "Eight", "Nine" };
		int c = 0;
		StringBuffer sb = new StringBuffer();
		while(num>0){
			String s = "";
			int x = num%1000;
			if(x<10){
				s = digit[x];
			}
			else if(x<20){
				s = teen[x%10];
			}
			else if(x<100){
				s = ty[x/10] +" "+ digit[x%10];
			}
			else if(x<1000){
				s = digit[x/100] + " Hundred and" + intToWord(x%100);
			}
			sb.insert(0, s+base[c++]);
			num = num/1000;
		}
		return sb.toString();
	}
	
}
