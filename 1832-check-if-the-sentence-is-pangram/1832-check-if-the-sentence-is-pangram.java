class Solution {
    public boolean checkIfPangram(String sentence) {
        HashSet<Character> letter=new HashSet<>();
        for(int i=0;i<sentence.length();i++)
        {
            letter.add(sentence.charAt(i));
        }
        if(letter.size()==26)
            return true;
        return false;
    }
}