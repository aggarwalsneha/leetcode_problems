class Solution {
    public int myAtoi(String s) {
    int num=0;
	boolean is_negative=false;
        s=s.trim();
	for(int i=0;i<s.length();i++){
	    char dig=s.charAt(i);
	    if(i==0 && dig=='-')
	        is_negative=true;
        else if(i==0 && dig=='+')
            continue;
	    else{
            int temp=dig-'0';
            if(temp>=0 && temp<=9){
                if(num<=(Integer.MAX_VALUE-temp)/10)
                    num=num*10+temp;
                else
                    return is_negative? Integer.MIN_VALUE:Integer.MAX_VALUE;
            }
            else
                break;
	    }
	}
	return is_negative?-num:num;
    }
}