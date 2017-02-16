public class IpValidate extends Solution {
    private static String pattern = "^(([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\.){3}([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";
    private String ip;
    public IpValidate(String iP) { 
        this.ip = iP;
    }
    
    public boolean isMatch() {
        return this.ip.matches(IpValidate.pattern);
    }
}
class Solution{

}
