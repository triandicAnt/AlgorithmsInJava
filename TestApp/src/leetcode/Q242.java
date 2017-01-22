public class Q242 {
    public boolean isAnagram(String s, String t) {
        char[]c = s.toCharArray();
        char []d = t.toCharArray();
        Arrays.sort(c);
        Arrays.sort(d);
        return String.valueOf(c).equals(String.valueOf(d));
    }
}
