class Solution {
    public String customSortString(String order, String s) {
        int n=s.length();
        Character[] res=new Character[n];
        for(int i=0;i<n;i++) {
            res[i]=s.charAt(i);
        }
        Arrays.sort(res,(c1, c2)->{
            return order.indexOf(c1)-order.indexOf(c2);
        });
        String result="";
        for(Character c:res){
            result+=c;
        }
        return result;
    }
}