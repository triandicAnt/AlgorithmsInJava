public class Q119 {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> l = new ArrayList<>();
        if(rowIndex<0)
            return l;
        for(int i = 0;i<=rowIndex;i++){
            l.add(0,1);
            for(int j = 1;j<l.size()-1;j++)
                l.set(j, l.get(j)+l.get(j+1));
        }
        return l;
    }
}
