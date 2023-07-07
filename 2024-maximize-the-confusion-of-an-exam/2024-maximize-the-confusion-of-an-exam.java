class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int maxFreq=0;
        int i=0;
        Map<Character,Integer> hm=new HashMap<>();

        for(int j=0;j<answerKey.length();j++){
            char ch=answerKey.charAt(j);
            hm.put(ch,hm.getOrDefault(ch,0)+1);
            maxFreq=Math.max(maxFreq,hm.get(ch));
            if(j-i+1>maxFreq+k){
                hm.put(answerKey.charAt(i),hm.get(answerKey.charAt(i))-1);
                i++;
            }
        }
        return answerKey.length()-i; 
    }
}