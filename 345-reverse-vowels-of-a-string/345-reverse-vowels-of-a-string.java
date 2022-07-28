class Solution {
    public String reverseVowels(String s) {
        int i = 0;
        int j = s.length()-1;
        char c[]=s.toCharArray();
        while(i<=j){
            if(!isVowel(c[j])) 
                j--;
            else
            {
                if(!isVowel(c[i]))
                    i++;
                else{
                    swap(i,j,c);
                    i++;
                    j--;
                }
            }
        }
        return new String(c);
    }
    
 public boolean isVowel(char c){
    switch(c){
            case 'a' -> {return true;}
            case 'e' -> {return true;}
            case 'i' -> {return true;}
            case 'o' -> {return true;}
            case 'u' -> {return true;}
            case 'A' -> {return true;}
            case 'E' -> {return true;}
            case 'I' -> {return true;}
            case 'O' -> {return true;}
            case 'U' -> {return true;}
            default -> {return false;}
    }
}
    
    public void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}