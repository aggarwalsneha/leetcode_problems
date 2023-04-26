class Solution {
    public int addDigits(int num) {
      int digit = 0;
        while (num>0) {
            digit += num % 10;
            num=num/10;
            
            if (num==0 && digit>9) {
                num=digit;
                digit=0;  
            }    
        }     
        return digit;
        
    }
}