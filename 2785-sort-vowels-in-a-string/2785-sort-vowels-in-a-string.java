class Solution {
    public String sortVowels(String s) {
        ArrayList<Character> vowels=new ArrayList<>();
        for(char c:s.toCharArray()){
            if(isVowel(c)){
                vowels.add(c);
            }
        }
        Collections.sort(vowels);
        StringBuilder ans=new StringBuilder();
        int j=0;
        for(int i=0;i<s.length();i++){
            if(isVowel(s.charAt(i))){
                ans.append(vowels.get(j));
                j++;
            }
            else{
                ans.append(s.charAt(i));
            }
        }
        return ans.toString();
    }
    
    boolean isVowel(Character c){
        return c=='a'||c=='e'||c=='o'||c=='u'||c=='i'||c =='A'||c=='E'||c=='O'||c =='U'||c=='I';
    }
}