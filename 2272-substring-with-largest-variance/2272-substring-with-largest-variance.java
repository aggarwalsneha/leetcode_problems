class Solution {
    public int largestVariance(String s) {
        int[] freq=new int[26];
        for(char ch:s.toCharArray()){
            freq[(int)(ch-'a')]++;
        }
        int globalMax = 0;
        for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                if(i==j || freq[i]==0 || freq[j]==0){
                    continue;
                }        
                char major=(char)('a'+i);
                char minor=(char)('a'+j);
                int majorCount=0;
                int minorCount=0;
                int restMinor=freq[j];
                
                for(char ch:s.toCharArray()){    
                    if(ch==major){
                        majorCount++;
                    }
                    if(ch==minor){
                        minorCount++;
                        restMinor--;
                    }
                    if(minorCount>0)
                        globalMax=Math.max(globalMax,majorCount-minorCount);
                    if (majorCount<minorCount && restMinor>0){
                        majorCount=0;
                        minorCount=0;
                    }
                }
            }
        }
        return globalMax;
    }
} 