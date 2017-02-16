public class ScannerTest {
    
	public static void main(String []args) {
        // Write your code here.
         Scanner scanner = new Scanner(System.in);
        List<String> list = new ArrayList<>();
        try {
            String input;
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
           }
            MyCalculator cal = new MyCalculator();
           for(String s : list){
               String[] vals = s.split("\\s+");
               try{
                    System.out.println(cal.power(Integer.parseInt(vals[0]),Integer.parseInt(vals[1])));
               }catch (Exception e) {
                    System.out.println("java.lang.Exception: "+e.getMessage());
                   continue;
               }
           } 
       
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
