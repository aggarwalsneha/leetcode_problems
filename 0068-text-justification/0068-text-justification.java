class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String>ans=new ArrayList<>();
        int i=0;
        while(i<words.length){
            List<String> temp=getWords(i,words,maxWidth);
            i+=temp.size();
            ans.add(create(temp,i,words,maxWidth));
        }
        return ans;
    }
    
    List<String> getWords(int i,String[] words,int maxWidth){
        List<String> temp=new ArrayList<>();
        int len=0;
        while(i<words.length && len+words[i].length()<=maxWidth){
            temp.add(words[i]);
            len+=words[i].length()+1;
            i++;
        }
        return temp;
    }
    
    String create(List<String>line,int i,String[] words,int maxWidth){
        int baseLength=-1;
        for(String word:line) {
            baseLength+=word.length()+1;
        }

        int extraSpaces=maxWidth-baseLength;

        if(line.size()== 1 || i==words.length){
            return String.join(" ",line)+" ".repeat(extraSpaces);
        }
        int wordCount=line.size()-1;
        int spacesPerWord=extraSpaces/wordCount;
        int needsExtraSpace=extraSpaces%wordCount;

        for(int j=0;j<needsExtraSpace;j++){
            line.set(j,line.get(j)+" ");
        }

        for(int j=0;j<wordCount;j++){
            line.set(j,line.get(j)+ " ".repeat(spacesPerWord));
        }
        return String.join(" ",line);
    }
}