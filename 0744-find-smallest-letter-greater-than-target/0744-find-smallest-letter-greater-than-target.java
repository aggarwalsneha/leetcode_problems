class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int first=0;
        int last= letters.length;
        while(first<last){
        int middle=(first+last)/2;
        
        if(letters[middle]<=target)
           first=middle+1;
        else
           last=middle;
        }
        return letters[first%letters.length];
        
    }
}