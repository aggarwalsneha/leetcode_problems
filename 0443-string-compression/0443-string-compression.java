class Solution {
    public int compress(char[] chars) {
        int i=0,ans=0;
        while(i<chars.length){
            int len=1;
            while(i+len<chars.length && chars[i+len]==chars[i]){
                len++;
            }
            chars[ans++]=chars[i];
            if(len>1){
                for(char c:Integer.toString(len).toCharArray()){
                    chars[ans++]=c;
                }
            }
            i+=len;
        }
        return ans;
    }
}