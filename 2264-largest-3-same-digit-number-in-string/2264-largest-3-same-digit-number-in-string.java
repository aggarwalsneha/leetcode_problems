class Solution {
    public String largestGoodInteger(String num) {
        for(int i=9;i>=0;i--){
            String s=Integer.toString(i);
            s=s+s+s;
            if(num.contains(s)){
                return s;
            }
        }
        return "";
    }
}